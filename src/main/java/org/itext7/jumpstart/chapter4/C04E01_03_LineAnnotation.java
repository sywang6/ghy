package org.itext7.jumpstart.chapter4;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfLineAnnotation;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;

/**
 * Simple line annotation example.
 */
public class C04E01_03_LineAnnotation {
    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH + "results/chapter04/line_annotation.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C04E01_03_LineAnnotation().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PdfPage page = pdf.addNewPage();

        PdfCanvas canvas = new PdfCanvas(page);
        canvas//.saveState()
                .beginText()
                .setFontAndSize(PdfFontFactory.createFont(StandardFonts.HELVETICA), 9)
                .moveText( 20, page.getPageSize().getTop() - 20)
                .showText("THE TRUTH IS OUT THERE")
                .endText();
               // .restoreState();

        PdfArray lineEndings = new PdfArray();
        //正方形
        lineEndings.add(new PdfName("Square"));
        //菱形
        lineEndings.add(new PdfName("Diamond"));

        //Create line annotation with inside caption
        PdfAnnotation annotation = new PdfLineAnnotation(
                new Rectangle(0, 0),
                //线条的起点和端点
                new float[]{100, 790, page.getPageSize().getWidth() - 100, 790})
                //设置箭头形状
                .setLineEndingStyles((lineEndings))
                .setContentsAsCaption(true)
                .setTitle(new PdfString("iText"))
                .setContents("The example of line annotation")
                .setColor(ColorConstants.BLUE);
        page.addAnnotation(annotation);

        //Close document
        pdf.close();
    }
}
