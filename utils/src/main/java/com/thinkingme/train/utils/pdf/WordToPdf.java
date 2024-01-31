package com.thinkingme.train.utils.pdf;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 14/12/2023 下午1:50
 */
import com.aspose.words.License;
import com.aspose.words.PdfSaveOptions;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import fr.opensagres.poi.xwpf.converter.core.FileImageExtractor;
import fr.opensagres.poi.xwpf.converter.core.FileURIResolver;
import fr.opensagres.poi.xwpf.converter.core.ImageManager;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.Charset;
import java.util.UUID;

public class WordToPdf {
    public static void main(String[] args) throws Exception {
        String inputFile = "C:\\Users\\huige\\Desktop\\厦门服务信托对外接口文档.docx";
        String outputFile = "C:\\Users\\huige\\Desktop\\test.pdf";
        String imageDir = "C:\\Users\\huige\\Desktop\\";
        getLicense();
        doc2pdf(inputFile, outputFile);
    }

    /**
     * 使用aspose-words工具将doc、docx文件转成pdf
     *
     * @exception 说明 ：1、RN组件无法正常打开word文档，因此需要转换成pdf
     *               2、当下载word文档时会在文件名后加.pdf再传给后端
     *               3、只有文件名如：1.doc.pdf和2.docx.pdf才会被转换成pdf，1.doc和2.docx不会
     *
     * @param sourcePath 源文件地址
     * @param pdfPath    转换后的pdf文件保存地址
     * @return String 返回源地址或者转换后的地址
     */
    public static void doc2pdf(String inputFile, String sourcePath) throws Exception {
        //加载Word文档
        com.aspose.words.Document doc = new com.aspose.words.Document(inputFile);
//创建 PDF 保存选项对象
        PdfSaveOptions saveOptions = new PdfSaveOptions();

//将文档另存为 PDF
        doc.save(sourcePath, saveOptions);

    }

    /**
     * 获取aspose-words授权
     *
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
//          InputStream is = this.getClass().getResourceAsStream("license.xml");// 获取当前类所在package下的文件
            // 用于注册的配置(直接获取xml文件在fsdp有问题，因此直接用字符串再转文件流)
            String license = "<License>\r\n" + "  <Data>\r\n" + "    <Products>\r\n" + "      <Product>Aspose.Total for Java</Product>\r\n" + "      <Product>Aspose.Words for Java</Product>\r\n" + "    </Products>\r\n" + "    <EditionType>Enterprise</EditionType>\r\n"
                    + "    <SubscriptionExpiry>20991231</SubscriptionExpiry>\r\n" + "    <LicenseExpiry>20991231</LicenseExpiry>\r\n" + "    <SerialNumber>23dcc79f-44ec-4a23-be3a-03c1632404e9</SerialNumber>\r\n" + "  </Data>\r\n"
                    + "  <Signature>0nRuwNEddXwLfXB7pw66G71MS93gW8mNzJ7vuh3Sf4VAEOBfpxtHLCotymv1PoeukxYe31K441Ivq0Pkvx1yZZG4O1KCv3Omdbs7uqzUB4xXHlOub4VsTODzDJ5MWHqlRCB1HHcGjlyT2sVGiovLt0Grvqw5+QXBuinoBY0suX0=</Signature>\r\n" + "</License>\r\n" + "";

            InputStream is = new ByteArrayInputStream(license.getBytes());// 转成文件流
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void wordToPdf(String inputFile, String outputFile) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream  fileOutputStream=null;
        try {
            // 读取docx文件
            fileInputStream = new FileInputStream(inputFile);
            XWPFDocument xwpfDocument = new XWPFDocument(fileInputStream);
            PdfOptions pdfOptions = PdfOptions.create();
            // 输出路径
            fileOutputStream = new FileOutputStream(outputFile);
            // 调用转换
            PdfConverter.getInstance().convert(xwpfDocument,fileOutputStream,pdfOptions);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    /**
     * 将doc格式文件转成html
     *
     * @param docPath  doc文件路径
     * @param imageDir doc文件中图片存储目录
     * @return html
     */
    public static String doc2Html(String docPath, String imageDir) {
        String content = null;
        ByteArrayOutputStream baos = null;
        try {

            HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(docPath));
            WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
            wordToHtmlConverter.setPicturesManager(new PicturesManager() {
                @Override
                public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches, float heightInches) {
                    File file = new File(imageDir + suggestedName);
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(file);
                        fos.write(content);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (fos != null) {
                                fos.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return imageDir + suggestedName;
                }
            });
            wordToHtmlConverter.processDocument(wordDocument);
            Document htmlDocument = wordToHtmlConverter.getDocument();
            DOMSource domSource = new DOMSource(htmlDocument);
            baos = new ByteArrayOutputStream();
            StreamResult streamResult = new StreamResult(baos);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer serializer = tf.newTransformer();
            serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.setOutputProperty(OutputKeys.METHOD, "html");
            serializer.transform(domSource, streamResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    content = new String(baos.toByteArray(), "utf-8");
                    baos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    /**
     * 将docx格式文件转成html
     *
     * @param docxPath docx文件路径
     * @param htmlPath docx文件中图片存储目录
     * @return html
     */
    public static void  docx2Html(String docxPath, String htmlPath,String imageDir) {
        String content = null;

        FileInputStream in = null;
        FileOutputStream out = null;
        ByteArrayOutputStream baos = null;
        try {
            // 1> 加载文档到XWPFDocument
            in = new FileInputStream(new File(docxPath));
            out = new FileOutputStream( htmlPath );
            File outFile = new File( htmlPath );
            outFile.getParentFile().mkdirs();
            XWPFDocument document = new XWPFDocument(in);
            // 2> 解析XHTML配置（这里设置IURIResolver来设置图片存放的目录）
            XHTMLOptions options = XHTMLOptions.create();
            options.setImageManager(new ImageManager(new File(imageDir),"image"));
            // 存放word中图片的目录
            options.setIgnoreStylesIfUnused(false);
            options.setFragment(true);
            // 3> 将XWPFDocument转换成XHTML
            baos = new ByteArrayOutputStream();
            XHTMLConverter.getInstance().convert(document, out, options);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用jsoup规范化html
     *
     * @param html html内容
     * @return 规范化后的html
     */
//    private static String formatHtml(String html) {
//        org.jsoup.nodes.Document doc = Jsoup.parse(html);
//        // 去除过大的宽度
//        String style = doc.attr("style");
//        if (StringUtils.isNotEmpty(style) && style.contains("width")) {
//            doc.attr("style", "");
//        }
//        Elements divs = doc.select("div");
//        for (Element div : divs) {
//            String divStyle = div.attr("style");
//            if (StringUtils.isNotEmpty(divStyle) && divStyle.contains("width")) {
//                div.attr("style", "");
//            }
//        }
//        // jsoup生成闭合标签
//        doc.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
//        doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
//        return doc.html();
//    }


    /**
     * html转成pdf
     *
     * @param html          html
     * @param outputPdfPath 输出pdf路径
     */
    public static void htmlToPdf(String html, String outputPdfPath) {
        com.itextpdf.text.Document document = null;
        ByteArrayInputStream bais = null;
        try {
            // 纸
            document = new com.itextpdf.text.Document(PageSize.A4);
            // 笔
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPdfPath));
            document.open();

            // html转pdf
            bais = new ByteArrayInputStream(html.getBytes());
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, bais,
                    Charset.forName("UTF-8"), new FontProvider() {
                        @Override
                        public boolean isRegistered(String s) {
                            return false;
                        }

                        @Override
                        public Font getFont(String s, String s1, boolean embedded, float size, int style, BaseColor baseColor) {
                            // 配置字体
                            Font font = null;
                            try {
                                // 方案一：使用本地字体(本地需要有字体)
//                              BaseFont bf = BaseFont.createFont("c:/Windows/Fonts/simsun.ttc,0", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//                                BaseFont bf = BaseFont.createFont("C:/Windows/Fonts/seguisym.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                                // 方案二：使用jar包：iTextAsian，这样只需一个jar包就可以了
                                BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
                                font = new Font(bf, size, style, baseColor);
                                font.setColor(baseColor);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return font;
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
            if (bais != null) {
                try {
                    bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

