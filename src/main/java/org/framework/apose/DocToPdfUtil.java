package org.framework.apose;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.itext7.jumpstart.AabsolutePath;

import java.io.*;

public class DocToPdfUtil {



    public static void main(String[] args) throws Exception {
        //docToPdfWithOpensagres();
        //docToPdfWithDocuments4j();
        docToPdfWithAspose();
    }


    public static  void docToPdfWithOpensagres() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/doc/池保理合同（模板）.docx");
        XWPFDocument xwpfDocument = new XWPFDocument(fileInputStream);
        PdfOptions pdfOptions = PdfOptions.create();
        FileOutputStream fileOutputStream = new FileOutputStream(AabsolutePath.PROJECT_ROOR_PATH + "results/poi/池保理合同（模板）-Opensagres.pdf");
        PdfConverter.getInstance().convert(xwpfDocument,fileOutputStream,pdfOptions);
        fileInputStream.close();
        fileOutputStream.close();

    }


/*    public static  void docToPdfWithDocuments4j(){
        File inputWord = new File(AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/doc/池保理合同（模板）.docx");
        File outputFile = new File(AabsolutePath.PROJECT_ROOR_PATH + "results/poi/池保理合同（模板）-Documents4j.pdf");
        try  {
            InputStream docxInputStream = new FileInputStream(inputWord);
            OutputStream outputStream = new FileOutputStream(outputFile);
            IConverter converter = LocalConverter.builder().build();
            converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
            outputStream.close();
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/



    public static  void docToPdfWithAspose() throws Exception {

       try (InputStream is = DocToPdfUtil.class.getClassLoader().getResourceAsStream("License.xml")) {
            License license = new License();
            license.setLicense(is);
        }

        String wordPath = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/doc/订单详情截图.docx";
        String pdfPath = AabsolutePath.PROJECT_ROOR_PATH + "results/poi/订单详情截图-aspose.pdf";

        File file = new File(pdfPath);
        try (FileOutputStream os = new FileOutputStream(file)) {
            Document doc = new Document(wordPath);
            doc.save(os, SaveFormat.PDF);
        }
    }


}


