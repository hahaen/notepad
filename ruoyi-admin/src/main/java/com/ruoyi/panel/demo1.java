package com.ruoyi.panel;

import net.coobird.thumbnailator.Thumbnails;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @className: demo
 * @Description: TODO
 * @version: v1.8.0
 * @author: hahaen
 * @date: 2022/12/9 9:35
 */
public class demo1 {

    // 文字水印
    // Graphics2D实现

    public void addTextWaterMark(BufferedImage targetImg, Color textColor, int fontSize, String text, String outPath) {
        try {
            int width = targetImg.getWidth(); //图片宽
            int height = targetImg.getHeight(); //图片高
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(targetImg, 0, 0, width, height, null);
            g.setColor(textColor); //水印颜色
            g.setFont(new Font("微软雅黑", Font.ITALIC, fontSize));
            // 水印内容放置在右下角
            int x = width - (text.length() + 1) * fontSize;
            int y = height - fontSize * 2;
            g.drawString(text, x, y);
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
    public void addTextTest() throws IOException {
        File file = new File("D:\\Desktop\\test\\2.jpg");
        BufferedImage image = ImageIO.read(file);
        addTextWaterMark(image, Color.RED, 8, "测试文本水印", "D:\\Desktop\\test\\444.jpg");// 80 or 8
    }

}
