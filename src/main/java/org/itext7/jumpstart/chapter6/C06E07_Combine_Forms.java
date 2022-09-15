package org.itext7.jumpstart.chapter6;

import com.itextpdf.forms.PdfPageFormCopier;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;

/**
 * 合并表单
 */
public class C06E07_Combine_Forms {
    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH +"results/chapter06/combined_forms.pdf";
    public static final String SRC1 = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/pdf/subscribe.pdf";
    public static final String SRC2 = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/pdf/state.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C06E07_Combine_Forms().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        PdfDocument destPdfDocument = new PdfDocument(new PdfWriter(dest));
        PdfDocument[] sources = new PdfDocument[] {
                new PdfDocument(new PdfReader(SRC1)),
                new PdfDocument(new PdfReader(SRC2))
        };
        PdfPageFormCopier formCopier = new PdfPageFormCopier();
        //表单复制
        for (PdfDocument sourcePdfDocument : sources) {
            sourcePdfDocument.copyPagesTo(
                    1, sourcePdfDocument.getNumberOfPages(),
                    destPdfDocument, formCopier);
            sourcePdfDocument.close();
        }
        destPdfDocument.close();
    }

}
