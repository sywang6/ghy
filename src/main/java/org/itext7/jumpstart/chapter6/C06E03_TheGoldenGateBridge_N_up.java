package org.itext7.jumpstart.chapter6;

import com.itextpdf.kernel.geom.AffineTransform;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;

/**
 * 把N页放到一个页面上
 */
public class C06E03_TheGoldenGateBridge_N_up {
    public static final String SRC = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/pdf/the_golden_gate_bridge.pdf";
    public static final String DEST =AabsolutePath.PROJECT_ROOR_PATH + "results/chapter06/the_golden_gate_bridge_nup.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C06E03_TheGoldenGateBridge_N_up().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PdfDocument sourcePdf = new PdfDocument(new PdfReader(SRC));

        //Original page
        PdfPage origPage = sourcePdf.getPage(1);

        //Original page size
        Rectangle orig = origPage.getPageSize();
        PdfFormXObject pageCopy = origPage.copyAsFormXObject(pdf);

        //N-up page
        PageSize nUpPageSize = PageSize.A4.rotate();
        PdfPage page = pdf.addNewPage(nUpPageSize);
        PdfCanvas canvas = new PdfCanvas(page);

        //Scale page
        AffineTransform transformationMatrix = AffineTransform.getScaleInstance(nUpPageSize.getWidth() / orig.getWidth() / 2f, nUpPageSize.getHeight() / orig.getHeight() / 2f);
        canvas.concatMatrix(transformationMatrix);

        //Add pages to N-up page
        canvas.addXObjectAt(pageCopy, 0, orig.getHeight());
        canvas.addXObjectAt(pageCopy, orig.getWidth(), orig.getHeight());
        canvas.addXObjectAt(pageCopy, 0, 0);
        canvas.addXObjectAt(pageCopy, orig.getWidth(), 0);

        pdf.close();
        sourcePdf.close();
    }
}
