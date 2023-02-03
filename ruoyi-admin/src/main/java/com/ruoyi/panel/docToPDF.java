package com.ruoyi.panel;

import java.io.File;
import java.nio.file.Files;
import java.util.Objects;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * @className: excelToPDF
 * @Description: TODO
 * @version: v1.8.0
 * @author: hahaen
 * @date: 2022/12/9 14:59
 */
public class docToPDF {
    /**
     * word 转换为 pdf 的格式宏，值为 17
     */
    private static final int WORD_FORMAT_PDF = 17;
    private static final String MS_OFFICE_APPLICATION = "Word.Application";
    private static final String WPS_OFFICE_APPLICATION = "KWPS.Application";

    /**
     * 微软Office Word转PDF
     * 如果无法转换，可能需要下载 SaveAsPDFandXPS.exe 插件并安装
     *
     * @param wordFile Word文件
     * @param pdfFile  Pdf文件
     */
    public static void msOfficeToPdf(String wordFile, String pdfFile) {
        wordToPdf(wordFile, pdfFile, MS_OFFICE_APPLICATION);
    }

    /**
     * WPS Office Word转PDF
     *
     * @param wordFile Word文件
     * @param pdfFile  Pdf文件
     */
    public static void wpsOfficeToPdf(String wordFile, String pdfFile) {
        wordToPdf(wordFile, pdfFile, WPS_OFFICE_APPLICATION);
    }


    /**
     * Word 转 PDF
     *
     * @param wordFile    Word文件
     * @param pdfFile     Pdf文件
     * @param application Office 应用
     */
    private static void wordToPdf(String wordFile, String pdfFile, String application) {
        Objects.requireNonNull(wordFile);
        Objects.requireNonNull(pdfFile);
        Objects.requireNonNull(application);

        ActiveXComponent app = null;
        Dispatch document = null;
        try {
            File outFile = new File(pdfFile);
            // 如果目标路径不存在, 则新建该路径，否则会报错
            if (!outFile.getParentFile().exists()) {
                Files.createDirectories(outFile.getParentFile().toPath());
            }

            // 如果目标文件存在，则先删除
            if (outFile.exists()) {
                outFile.delete();
            }

            // 这里需要根据当前环境安装的是 MicroSoft Office还是WPS来选择
            // 如果安装的是WPS，则需要使用 KWPS.Application
            // 如果安装的是微软的 Office，需要使用 Word.Application
            app = new ActiveXComponent(application);
            app.setProperty("Visible", new Variant(false));
            app.setProperty("AutomationSecurity", new Variant(3));

            Dispatch documents = app.getProperty("Documents").toDispatch();
            document = Dispatch.call(documents, "Open", wordFile, false, true).toDispatch();

            Dispatch.call(document, "ExportAsFixedFormat", pdfFile, WORD_FORMAT_PDF);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                Dispatch.call(document, "Close", false);
            }

            if (app != null) {
                app.invoke("Quit", 0);
            }

            ComThread.Release();
        }
    }

    //excel转PDF
    private static final String xlTypePDF = "0";


    public static void main(String[] args) {
//        msOfficeToPdf("D:\\Desktop\\test\\Vue01.docx", "D:\\Desktop\\test\\writeTest.pdf");
        excelToPDF("D:\\Desktop\\test\\writeTest.xlsx", "D:\\Desktop\\test\\111.pdf");
    }

    public static boolean excelToPDF(String srcFilePath, String pdfFilePath) {
        ActiveXComponent app = null;
        Dispatch excel = null;
        try {

            ComThread.InitSTA(true);
            app = new ActiveXComponent("Excel.Application");
            System.out.println("*****正在转换...*****");
            long date = System.currentTimeMillis();
            app.setProperty("Visible", false);
            app.setProperty("AutomationSecurity", new Variant(3)); // 禁用宏
            Dispatch excels = app.getProperty("Workbooks").toDispatch();

            excel = Dispatch
                    .invoke(excels, "Open", Dispatch.Method,
                            new Object[]{srcFilePath, new Variant(false), new Variant(false)}, new int[9])
                    .toDispatch();
            // 转换格式
            Dispatch.put(excel, "CheckCompatibility", false);
            app.setProperty("DisplayAlerts", false);
            Dispatch.invoke(excel, "ExportAsFixedFormat", Dispatch.Method, new Object[]{new Variant(0), // PDF格式=0
                    pdfFilePath, new Variant(xlTypePDF) // 0=标准 (生成的PDF图片不会变模糊) 1=最小文件
                    // (生成的PDF图片糊的一塌糊涂)
            }, new int[1]);
            app.setProperty("DisplayAlerts", true);
            System.out.println("*****转换成功...*****");
            // 这里放弃使用SaveAs
            /*
             * Dispatch.invoke(excel,"SaveAs",Dispatch.Method,new Object[]{
             * outFile, new Variant(57), new Variant(false), new Variant(57),
             * new Variant(57), new Variant(false), new Variant(true), new
             * Variant(57), new Variant(true), new Variant(true), new
             * Variant(true) },new int[1]);
             */

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
            return false;
        } finally {
            if (excel != null) {
                Dispatch.call(excel, "Close", false);
            }
            if (app != null) {
                app.invoke("Quit", new Variant[]{});
                //app.invoke("Quit", 0);
            }
            ComThread.Release();
        }
    }

}
