package com.thinkingme.train.utils.cv;

import org.bytedeco.javacv.FFmpegFrameFilter;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.FFmpegLogCallback;

/**
 * <p>
 * 使用java cv调用ffmpeg实现转码成mp4以供在h5页面中播放
 * 前端使用字节的西瓜播放器
 * 后端可以用spring自带的静态文件handler ResourceHttpRequestHandler
 * 进行自定义资源读取后，能够使用spring的range处理实现在线实时播放
 * </p>
 *
 * @author: huige
 * @date: 2/1/2024 下午10:09
 */
public class CvMain {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Video video1 = new Video("C:\\Users\\huige\\Desktop\\1", "4.wmv");
//        Video video2 = new Video("C:\\Users\\huige\\Desktop\\1", "2.AVI");
//        Video video3 = new Video("C:\\Users\\huige\\Desktop\\1", "3.MOV");

            String convert2Mp4 = video1.convert2Mp4();
//        if (video2.isVideo()) {
//            String convert2Mp4 = video1.convert2Mp4();
//        }
//        if (video3.isVideo()) {
//            String convert2Mp4 = video3.convert2Mp4();
//        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start)/1000 + "s");
    }
}
