package com.ruoyi.htmlTop;

import gui.ava.html.parser.HtmlParser;
import gui.ava.html.parser.HtmlParserImpl;
import gui.ava.html.renderer.ImageRenderer;
import gui.ava.html.renderer.ImageRendererImpl;

/**
 * @className: demo2
 * @Description: TODO
 * @version: v1.8.0
 * @author: hahaen
 * @date: 2022/12/12 11:45
 */
public class demo2 {

    public static void main(String[] args) {
        HtmlParser htmlParser = new HtmlParserImpl();

        String format = "<p>\n" +
                "每个11111表格从一个 table 标签开始。 \n" +
                "每个2222表格行从 tr 标签开始。\n" +
                "每个表格的数据从 td 标签开始。\n" +
                "</p>\n" +
                "\n" +
                "<h4>一列:</h4>\n" +
                "<table border=\"1\">\n" +
                "<tr>\n" +
                "  <td>100</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "\n" +
                "<h4>一行三列:</h4>\n" +
                "<table border=\"1\">\n" +
                "<tr>\n" +
                "  <td>100</td>\n" +
                "  <td>200</td>\n" +
                "  <td>300</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "\n" +
                "<h4>两行三列:</h4>\n" +
                "<table border=\"1\">\n" +
                "<tr>\n" +
                "  <td>100</td>\n" +
                "  <td>200</td>\n" +
                "  <td>300</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "  <td>400</td>\n" +
                "  <td>500</td>\n" +
                "  <td>600</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        String finalHtml = "<html></body>" + format + "</body></html>";

        htmlParser.loadHtml(finalHtml);
        // jpg会变红
//         ImageRenderer imageRenderer = new ImageRendererImpl(htmlParser);
        // 修复jpg变红问题
        ImageRenderer imageRenderer = new ImageRendererSubImpl(htmlParser);
        String fileName = "D:\\Desktop\\test\\20230131\\hahaha333.jpg";
        imageRenderer.saveImage(fileName);
    }

    static String html = "<table border=\"1\">\n" +
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
}
