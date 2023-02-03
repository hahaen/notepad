package com.ruoyi.panel;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @className: demo2
 * @Description: 图片水印 Graphics2D实现
 * @version: v1.8.0
 * @author: hahaen
 * @date: 2022/12/9 10:12
 */
public class demo2 {

    // 图片水印
    // Graphics2D实现
    public void addImageWaterMark(BufferedImage targetImg, BufferedImage waterImg, String outPath) {
        try {
            int width = targetImg.getWidth(); //图片宽
            int height = targetImg.getHeight(); //图片高
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(targetImg, 0, 0, width, height, null);
            // 水印内容放置在右下角
            int x = width - waterImg.getWidth();
            int y = height - waterImg.getHeight();
            g.drawImage(waterImg, x, y, waterImg.getWidth(), waterImg.getHeight(), null);
            FileOutputStream outImgStream = new FileOutputStream(outPath);
            ImageIO.write(bufferedImage, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
            g.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addImg1Test() throws IOException {
        BufferedImage targetImg = ImageIO.read(new File("D:\\Desktop\\test\\1.jpg"));
        BufferedImage waterImage = ImageIO.read(new File("D:\\Desktop\\test\\2.jpg"));
        addImageWaterMark(targetImg, waterImage, "D:\\Desktop\\test\\1111.jpg");
    }
}
