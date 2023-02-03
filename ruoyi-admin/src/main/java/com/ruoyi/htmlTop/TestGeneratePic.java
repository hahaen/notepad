package com.ruoyi.htmlTop;

import gui.ava.html.image.generator.HtmlImageGenerator;

/**
 * @className: TestGeneratePic
 * @Description: TODO
 * @version: v1.8.0
 * @author: hahaen
 * @date: 2022/12/12 11:13
 */
public class TestGeneratePic {
    public static void main(String[] args) {
        generatePic();
    }

    public static void generatePic() {
        HtmlImageGenerator htmlImageGenerator = new HtmlImageGenerator();

        //format 表示html里的元素，比如表格
        String html = "<table border=\"1\">\n" +
                "   <tr>\n" +
                "     <th>名称</th>\n" +
                "     <th>官网</th>\n" +
                "     <th>性质</th>\n" +
                "     <th>性质</th>\n" +
                "     <th>性质</th>\n" +
                "     <th>性质</th>\n" +
                "     <th>性质性质性质性" +
                "质性质性质性质</th>\n" +

                "   </tr>\n" +
                "   <tr>\n" +
                "     <td>C语言中文网</td>\n" +
                "     <td>http://c.biancheng.net/</td>\n" +
                "     <td>教育</td>\n" +
                "   </tr>\n" +
                "    <tr>\n" +
                "     <td>百度</td>\n" +
                "     <td>http://www.baidu.com/</td>\n" +
                "     <td>搜索</td>\n" +
                "     </tr>\n" +
                "   <tr>\n" +
                "      <td>当当</td>\n" +
                "     <td>http://www.dangdang.com/</td>\n" +
                "      <td>图书</td>\n" +
                "    </tr>\n" +
                "</table>";
        htmlImageGenerator.loadHtml(html);
 
        //图片名
        String fileName = "D:\\Desktop\\test\\20230131\\hahaha1121.png";

         htmlImageGenerator.saveAsImage(fileName);

    }
}
