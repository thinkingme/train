package com.thinkingme.system.download;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2023/11/20 13:52
 */
public class ChannelTest {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url = new URL("https://live5.apexsoft.com.cn/index/download?resource=LiveInitializr-1.0.3.jar");

        String target = "c:/Users/huige/Desktop/bbb.jar";
        downloadByNIO2(url.toString(),target);
    }
    public static void downloadByNIO2(String url, String targetPath) {
        try (InputStream ins = new URL(url).openStream()) {
            Path target = Paths.get(targetPath);
            Files.createDirectories(target.getParent());
            Files.copy(ins, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadByNIO(String url, String targetPath) {
        ReadableByteChannel  rbc = null;
        FileOutputStream fos = null;
        FileChannel foutc = null;
        try {
            rbc = Channels.newChannel(new URL(url).openStream());
            File file = new File(targetPath);
            file.getParentFile().mkdirs();
            fos = new FileOutputStream(file);
            foutc = fos.getChannel();
            foutc.transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rbc != null) {
                try {
                    rbc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (foutc != null) {
                try {
                    foutc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 使用传统io stream 下载文件
     * @param url
     * @param saveDir
     * @param fileName
     */
    public static void download(String url, String saveDir, String fileName) {

        BufferedOutputStream bos = null;
        InputStream is = null;
        try {
            byte[] buff = new byte[8192];
            is = new URL(url).openStream();
            File file = new File(saveDir, fileName);
            file.getParentFile().mkdirs();
            bos = new BufferedOutputStream(new FileOutputStream(file));
            int count = 0;
            while ( (count = is.read(buff)) != -1) {
                bos.write(buff, 0, count);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
