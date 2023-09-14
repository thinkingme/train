package com.thinkingme.train.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * <p>
 *     图片加水印
 * </p>
 *
 * @author: huige
 * @date: 2022/5/26 19:15
 */
public class imgWatermark {
    // 水印透明度
    private static float alpha = 0.1f;
    // 水印横向位置
    private static int positionWidth = 200;
    // 水印纵向位置
    private static int positionHeight = 200;
    // 水印文字颜色
    private static Color color = new Color(138, 140, 142);;

    //图片加水印
    public static void main(String[] args) throws Exception {
        imgWatermarkByThumbnailator("D:\\home\\xtcrm\\data\\app\\TFP_CPTJCL\\59.FJ","我爱你","D:\\home\\xtcrm\\data\\app\\TFP_CPTJCL\\ThumbnailatorOut.jpg");
        imgWatermarkByJava("D:\\home\\xtcrm\\data\\app\\TFP_CPTJCL\\59.FJ","我爱你","D:\\home\\xtcrm\\data\\app\\TFP_CPTJCL\\out.jpg");
    }
    //thumbnailator给图片添加文字水印

    public static void imgWatermarkByThumbnailator(String path, String waterMark, String outPath) throws Exception {

        Thumbnails.of(path)
                .size(1980, 1080)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(path)), 0.5f)
                .outputQuality(0.8f)
                .toFile(outPath);
    }



    // java自带方法添加水印，密度为
    public static void imgWatermarkByJava(String srcPath, String waterMark, String targetPath) throws Exception {


        Image sourceImg = ImageIO.read(new File(srcPath));
        if (sourceImg == null) {
            throw new Exception("图片加水印失败，原因：图片不存在");
        }
        BufferedImage buffImg = new BufferedImage(sourceImg.getWidth(null),sourceImg.getHeight(null), BufferedImage.TYPE_INT_RGB);



        // 画笔对象
        Graphics2D g = buffImg.createGraphics();
        // 设置对线段的锯齿状边缘处理
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(sourceImg.getScaledInstance(sourceImg.getWidth(null),sourceImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,null);
//        // 旋转角度
        g.rotate(Math.toRadians(315),(double) buffImg.getWidth() / 2,(double) buffImg.getHeight() / 2);

        int maxLen = Math.max(buffImg.getWidth(null), buffImg.getHeight(null));

        int minLen = Math.min(buffImg.getWidth(null), buffImg.getHeight(null));

        int fontSize = minLen / waterMark.length() /2;

        Font font = new Font("宋体",Font.BOLD, fontSize);
        // 设置水印文字
        g.setColor(color);
        g.setFont(font);
        // 设置水印文字透明度
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));

        int gap = fontSize * waterMark.length() /3*4;

        for (int i = -maxLen; i < maxLen*2; i += gap) {
            // 垂直居中
            for (int j = -maxLen; j < maxLen*2; j += gap) {
                g.drawString(waterMark, i, j);
            }
        }
//        g.drawString(waterMark, buffImg.getWidth() / 2 -  waterMark.length() * font.getSize() / 4, buffImg.getHeight() / 2);
        // 释放资源
        g.dispose();
//       os = new FileOutputStream(targerPath);
        ImageIO.write(buffImg, "jpg",new File(targetPath));
        buffImg.flush();
        buffImg = null;
        System.gc();
    }


}
