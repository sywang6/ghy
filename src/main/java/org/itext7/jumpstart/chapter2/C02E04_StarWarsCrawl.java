package org.itext7.jumpstart.chapter2;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C02E04_StarWarsCrawl {

    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH +"results/chapter02/star_wars_crawl.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C02E04_StarWarsCrawl().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {

        List<String> text = new ArrayList();
        text.add("            Episode V      ");
        text.add("    THE EMPIRE STRIKES BACK  ");
        text.add("It is a dark time for the");
        text.add("Rebellion. Although the Death");
        text.add("Star has been destroyed,");
        text.add("Imperial troops have driven the");
        text.add("Rebel forces from their hidden");
        text.add("base and pursued them across");
        text.add("the galaxy.");
        text.add("Evading the dreaded Imperial");
        text.add("Starfleet, a group of freedom");
        text.add("fighters led by Luke Skywalker");
        text.add("has established a new secret");
        text.add("base on the remote ice world");
        text.add("of Hoth...");

        int maxStringWidth = 0;
        for (String fragment : text) {
            if (fragment.length() > maxStringWidth) {
                maxStringWidth = fragment.length();
            }
        }

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));

        //Add new page
        PageSize ps = PageSize.A4;
        PdfPage page = pdf.addNewPage(ps);

        PdfCanvas canvas = new PdfCanvas(page);
        //Set black background.
        //画一个矩形,起点(0,0)左下角,指定宽和高,并用黑色填充
        canvas.rectangle(0, 0, ps.getWidth(), ps.getHeight())
                .setColor(ColorConstants.BLACK, true)
                .fill();

        //Replace the origin of the coordinate system to the top left corner
        //变换坐标系,原点放到左上角
        canvas.concatMatrix(1, 0, 0, 1, 0, ps.getHeight());
        Color yellowColor = new DeviceCmyk(0.f, 0.0537f, 0.769f, 0.051f);
        float lineHeight = 5;
        float yOffset = -40;
        canvas.beginText()
                .setFontAndSize(PdfFontFactory.createFont(StandardFonts.COURIER_BOLD), 1)
                .setColor(yellowColor, true);
        for (int j = 0; j < text.size(); j++) {
            //读取一行
            String line = text.get(j);
            float xOffset = ps.getWidth() / 2 - 45 - 8 * j;
            float fontSizeCoeff = 6 + j;
            float lineSpacing = (lineHeight + j) * j / 1.5f;
            int stringWidth = line.length();
            //一个字符一个字符的显示
            for (int i = 0; i < stringWidth; i++) {
                float angle = (maxStringWidth / 2 - i) / 2f;
                float charXOffset = (4 + (float) j / 2) * i;
                //a,d定义缩放比例, c倾斜因子, (x,y)坐标
                canvas.setTextMatrix(fontSizeCoeff, 0,
                                angle, fontSizeCoeff / 1.5f,
                                xOffset + charXOffset, yOffset - lineSpacing)
                        .showText(String.valueOf(line.charAt(i)));
            }
        }
        canvas.endText();

        //Close document
        pdf.close();
    }
}