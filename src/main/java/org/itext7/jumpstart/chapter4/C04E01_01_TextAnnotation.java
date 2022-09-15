package org.itext7.jumpstart.chapter4;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfTextAnnotation;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;

/**
 * Simple text annotation example.
 * pdf注释
 */
public class C04E01_01_TextAnnotation {
    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH + "results/chapter04/text_annotation.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C04E01_01_TextAnnotation().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));

        //Initialize document
        Document document = new Document(pdf);
        document.add(new Paragraph("The example of text annotation."));

        //Create text annotation
        PdfAnnotation ann = new PdfTextAnnotation(new Rectangle(20, 800, 0, 0))
                .setOpen(true)
                .setColor(ColorConstants.GREEN)
                .setTitle(new PdfString("iText"))
                .setContents("With iText, you can truly take your documentation needs to the next level.");
        pdf.getFirstPage().addAnnotation(ann);

        //Close document
        document.close();

    }

}
