package org.itext7.jumpstart.chapter1;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;

public class C01E03_QuickBrownFox {
    public static final String DOG =  AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/img/dog.bmp";
    public static final String FOX =  AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/img/fox.bmp";

    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH +"results/chapter01/quick_brown_fox.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C01E03_QuickBrownFox().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        // Compose Paragraph
        Image fox = new Image(ImageDataFactory.create(FOX));
        Image dog = new Image(ImageDataFactory.create(DOG));
        Paragraph p = new Paragraph("The quick brown ").setFontSize(12)
                .add(fox)
                .add(" jumps over the lazy ").setFontSize(9)
                .add(dog);
        // Add Paragraph to document
        document.add(p);

        //Close document
        document.close();
    }

}
