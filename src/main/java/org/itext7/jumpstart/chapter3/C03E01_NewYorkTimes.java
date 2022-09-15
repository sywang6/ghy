package org.itext7.jumpstart.chapter3;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.ColumnDocumentRenderer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03E01_NewYorkTimes {
    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH +"results/chapter03/new_york_times.pdf";

    public static final String APPLE_IMG = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/img/ny_times_apple.jpg";
    public static final String APPLE_TXT = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/data/ny_times_apple.txt";
    public static final String FACEBOOK_IMG = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/img/ny_times_fb.jpg";
    public static final String FACEBOOK_TXT = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/data/ny_times_fb.txt";
    public static final String INST_IMG = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/img/ny_times_inst.jpg";
    public static final String INST_TXT = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/data/ny_times_inst.txt";

    static PdfFont timesNewRoman = null;
    static PdfFont timesNewRomanBold = null;

    public static void main(String[] args) throws Exception {
        timesNewRoman = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        timesNewRomanBold = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C03E01_NewYorkTimes().createPdf(DEST);
    }

    protected void createPdf(String dest) throws Exception {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;

        // Initialize document
        Document document = new Document(pdf, ps);

        //Set column parameters
        float offSet = 36;
        float columnWidth = (ps.getWidth() - offSet * 2 + 10) / 3;
        float columnHeight = ps.getHeight() - offSet * 2;

        //Define column areas
        //划分为3列
        Rectangle[] columns = {new Rectangle(offSet - 5, offSet, columnWidth, columnHeight),
                new Rectangle(offSet + columnWidth, offSet, columnWidth, columnHeight),
                new Rectangle(offSet + columnWidth * 2 + 5, offSet, columnWidth, columnHeight)};
        //按列渲染
        document.setRenderer(new ColumnDocumentRenderer(document, columns));

        Image apple = new Image(ImageDataFactory.create(APPLE_IMG)).setWidth(columnWidth);
        String articleApple = new String(Files.readAllBytes(Paths.get(APPLE_TXT)), StandardCharsets.UTF_8);
        C03E01_NewYorkTimes.addArticle(document, "Apple Encryption Engineers, if Ordered to Unlock iPhone, Might Resist", "By JOHN MARKOFF MARCH 18, 2016", apple, articleApple);

        Image facebook = new Image(ImageDataFactory.create(FACEBOOK_IMG)).setWidth(columnWidth);
        String articleFB = new String(Files.readAllBytes(Paths.get(FACEBOOK_TXT)), StandardCharsets.UTF_8);
        C03E01_NewYorkTimes.addArticle(document, "With \"Smog Jog\" Through Beijing, Zuckerberg Stirs Debate on Air Pollution", "By PAUL MOZUR MARCH 18, 2016", facebook, articleFB);

        Image inst = new Image(ImageDataFactory.create(INST_IMG)).setWidth(columnWidth);
        String articleInstagram = new String(Files.readAllBytes(Paths.get(INST_TXT)), StandardCharsets.UTF_8);
        C03E01_NewYorkTimes.addArticle(document, "Instagram May Change Your Feed, Personalizing It With an Algorithm","By MIKE ISAAC MARCH 15, 2016", inst, articleInstagram);

        document.close();

    }
    public static void addArticle(Document doc, String title, String author, Image img, String text) throws IOException {
        Paragraph p1 = new Paragraph(title)
                .setFont(timesNewRomanBold)
                .setFontSize(14);
        doc.add(p1);
        doc.add(img);
        Paragraph p2 = new Paragraph()
                .setFont(timesNewRoman)
                .setFontSize(7)
                .setFontColor(ColorConstants.GRAY)
                .add(author);
        doc.add(p2);
        Paragraph p3 = new Paragraph()
                .setFont(timesNewRoman)
                .setFontSize(10)
                .add(text);
        doc.add(p3);
    }


}
