package com.thinkingme.train.utils.cv;


import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2/1/2024 下午10:08
 */
public class Video {
    private static final Logger logger = LoggerFactory.getLogger(Video.class);

    private static final String DEFAULT_EXTNAME = "mp4";

    private static final String DEFAULT_FORMAT = "mov,mp4,m4a,3gp,3g2,mj2";

    private VideoFormat videoFormat;

    public Video (String absolutePath) {
        this(new File(absolutePath));
    }

    public Video (String parent, String fileName) {
        this(new File(parent, fileName));
    }

    public Video (File file) {
        VideoFormat videoFormat = new VideoFormat();
        FFmpegFrameGrabber frameGrabber = null;
        try {
            videoFormat.setExists(file.exists());
            videoFormat.setFile(file.isFile());
            videoFormat.setAbsolutePath(file.getAbsolutePath());
            videoFormat.setParent(file.getParent());
            videoFormat.setName(file.getName());
            int dotLastIndex = videoFormat.getName().lastIndexOf(".");
            if (dotLastIndex > 0 && dotLastIndex < videoFormat.getName().length() - 1) {
                videoFormat.setSimpleName(videoFormat.getName().substring(0, dotLastIndex));
                videoFormat.setExtName(videoFormat.getName().substring(dotLastIndex + 1));
            } else {
                videoFormat.setSimpleName(videoFormat.getName());
            }
//            if (!file.isFile()) {
//                return;
//            }
//
//            frameGrabber = FFmpegFrameGrabber.createDefault(file);
//            frameGrabber.start();
//            videoFormat.setVideoCodec(frameGrabber.getVideoCodec());
//            videoFormat.setAudioCodec(frameGrabber.getAudioCodec());
//            videoFormat.setFormat(frameGrabber.getFormat());
        } catch (Exception e) {
            logger.warn(file.getAbsolutePath() + " -> error", e);
        } finally {
//            if (frameGrabber != null) {
//                try {
//                    frameGrabber.close();
//                } catch (org.bytedeco.javacv.FrameGrabber.Exception e) {
//                    logger.warn("frameGrabber.close异常", e);
//                }
//            }
        }
        this.videoFormat = videoFormat;
    }

    protected VideoFormat getVideoFormat() {
        return videoFormat;
    }

    public boolean isVideo () {
        return this.getVideoFormat().getVideoCodec() != avcodec.AV_CODEC_ID_NONE;
    }

    protected boolean hasAudio () {
        return this.getVideoFormat().getAudioCodec() != avcodec.AV_CODEC_ID_NONE;
    }

    protected boolean isMp4 () {
        return DEFAULT_EXTNAME.equalsIgnoreCase(this.getVideoFormat().getExtName());
    }

    protected boolean canPlayInH5IgnoreExtName () {
        if (!this.isVideo()) {
            return false;
        }
        VideoFormat videoFormat = this.videoFormat;
        if (this.hasAudio() && videoFormat.getAudioCodec() != avcodec.AV_CODEC_ID_AAC) {
            return false;
        }
        if (videoFormat.getVideoCodec() != avcodec.AV_CODEC_ID_H264) {
            return false;
        }
        if (!DEFAULT_FORMAT.equals(videoFormat.getFormat())) {
            return false;
        }
        return true;
    }

    public boolean canPlayInH5 () {
        if (!this.isMp4()) {
            return false;
        }
        return this.canPlayInH5IgnoreExtName();
    }

    public String convert2Mp4 () throws Exception {
        return this.convert2Mp4(this.videoFormat.getParent());
    }

    /**
     *
     * @param outputParent 输出目录
     * @return 输出文件的绝对路径
     * @throws Exception
     */
    public String convert2Mp4 (String outputParent) throws Exception {
        VideoFormat videoFormat = this.videoFormat;
//        if (!this.isVideo()) {
//            throw new org.bytedeco.javacv.FrameGrabber.Exception("[" + videoFormat.getAbsolutePath() + "] 不是视频文件");
//        }
        File outfile = new File(outputParent);
        if (outfile.isFile()) {
            throw new FileAlreadyExistsException("[" + outputParent + "] 是文件并且已存在");
        }
        if (!outfile.exists()) {
            outfile.mkdirs();
        }
        String outFilePath = new File(outputParent, videoFormat.getSimpleName() + "_recode." + DEFAULT_EXTNAME).getAbsolutePath();
        outFilePath = outFilePath.replace("\\", "/");
        //如果视频本来就能在浏览器中播放，则只进行复制
        if (this.canPlayInH5IgnoreExtName()) {
            Files.copy(new File(videoFormat.getParent(), videoFormat.getName()).toPath(), new File(outFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            return outFilePath;
        }
        FFmpegFrameGrabber frameGrabber = FFmpegFrameGrabber.createDefault(new File(videoFormat.getParent(), videoFormat.getName()));
        Frame captured_frame = null;
        FFmpegFrameRecorder recorder = null;
        try {
            frameGrabber.start();
            recorder = new FFmpegFrameRecorder(outFilePath, frameGrabber.getImageWidth(), frameGrabber.getImageHeight(), frameGrabber.getAudioChannels());
            //linux服务器可能不支持libx264 得用这个 设置编码为h264，浏览器播放编码
            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);

            //设置编码器h264_nvenc是需要英伟达的显卡，libx264是开源泛用的
            //recorder.setVideoCodecName("h264_nvenc");
            //linux服务器可能不支持libx264
            //libopenh264
            recorder.setVideoCodecName("libx264");

            recorder.setFormat(DEFAULT_EXTNAME);
            //recorder.setVideoBitrate(1000000);
            //recorder.setFrameRate(30);
            recorder.setVideoQuality(1);
            //recorder.setVideoOption("-minrate", "964K");
            //recorder.setVideoOption("-maxrate", "3856K");

            //采用原视频的各种属性
            recorder.setFrameRate(frameGrabber.getFrameRate());
            recorder.setVideoBitrate(frameGrabber.getVideoBitrate());
            recorder.setAspectRatio(frameGrabber.getAspectRatio());
            recorder.setAudioOptions(frameGrabber.getAudioOptions());
            recorder.setSampleRate(frameGrabber.getSampleRate());
            recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
            recorder.start();
            while (true) {
                captured_frame = frameGrabber.grabFrame();
                if (captured_frame == null) {
                    logger.info(outFilePath + "转码完成");
                    break;
                }
                recorder.record(captured_frame);
            }
        } finally {
            if (recorder != null) {
                try {
                    recorder.close();
                } catch (Exception e) {
                    logger.warn("recorder.close异常", e);
                }
            }
            if (frameGrabber != null) {
                try {
                    frameGrabber.close();
                } catch (org.bytedeco.javacv.FrameGrabber.Exception e) {
                    logger.warn("frameGrabber.close异常", e);
                }
            }

        }
        return outFilePath;
    }

}
