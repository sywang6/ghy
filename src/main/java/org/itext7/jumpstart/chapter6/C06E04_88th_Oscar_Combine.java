package org.itext7.jumpstart.chapter6;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;

/**
 * 合并文件
 */
public class C06E04_88th_Oscar_Combine {
    public static final String SRC1 = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/pdf/88th_reminder_list.pdf";
    public static final String SRC2 = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/pdf/88th_noms_announcement.pdf";
    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH +"results/chapter06/88th_oscar_combined_documents.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C06E04_88th_Oscar_Combine().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {

        //Initialize PDF document with output intent
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PdfMerger merger = new PdfMerger(pdf);

        //Add pages from the first document
        PdfDocument firstSourcePdf = new PdfDocument(new PdfReader(SRC1));
        merger.merge(firstSourcePdf, 1, firstSourcePdf.getNumberOfPages());

        //Add pages from the second pdf document
        //打开SRC2时会报一个异常,itext已经处理了这个异常,并不影响文件的打开
        PdfDocument secondSourcePdf = new PdfDocument(new PdfReader(SRC2));
        merger.merge(secondSourcePdf, 1, secondSourcePdf.getNumberOfPages());

        firstSourcePdf.close();
        secondSourcePdf.close();
        pdf.close();
        System.out.println("文件合并结束!");
    }
}
