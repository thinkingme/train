package com.thinkingme.train.utils.cv;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2/1/2024 下午10:08
 */
public class VideoFormat {

    private boolean exists;

    private boolean isFile;

    private String absolutePath;

    private String parent = "";

    private String name = "";

    private String simpleName = "";

    private String extName = "";//扩展名

    /**
     * @See {org.bytedeco.ffmpeg.global.avcodec}
     */
    private int videoCodec;//视频编码格式

    /**
     * @See {org.bytedeco.ffmpeg.global.avcodec}
     */
    private int audioCodec;//音频编码格式

    private String format = "";//封装格式

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean isFile) {
        this.isFile = isFile;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public int getVideoCodec() {
        return videoCodec;
    }

    public void setVideoCodec(int videoCodec) {
        this.videoCodec = videoCodec;
    }

    public int getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(int audioCodec) {
        this.audioCodec = audioCodec;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "VideoFormat [exists=" + exists + ", isFile=" + isFile + ", parent=" + parent + ", name=" + name
                + ", simpleName=" + simpleName + ", extName=" + extName + ", videoCodec=" + videoCodec + ", audioCodec="
                + audioCodec + ", format=" + format + "]";
    }

}
