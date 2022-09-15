package org.itext7.jumpstart.chapter3;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import org.itext7.jumpstart.AabsolutePath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * 当我们向文档添加拥有许多行的Table时，这个表很可能会分布在不同的页面上。
 * 在下图3中，我们看到存储在ufo.csv中的UFO目录列表。
 * 每个奇数页面的背景都是绿黄色，每个偶数页的背景都是蓝色的。
 * 每一页有页眉“THE TRUTH IS OUT THERE”，
 * 在实际的页面内容下有一个水印“CONFIDENTIAL”,在每页的底部为中心，有一个页码
 */
public class C03E03_UFO {
    public static final String DATA = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/data/ufo.csv";
    public static final String DEST =AabsolutePath.PROJECT_ROOR_PATH + "results/chapter03/ufo.pdf";

    static PdfFont helvetica = null;
    static PdfFont helveticaBold = null;

    public static void main(String[] args) throws Exception {
        helvetica = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        helveticaBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C03E03_UFO().createPdf(DEST);
    }

    protected void createPdf(String dest) throws Exception {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        //EndPdfPage事件监听
        pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new MyEventHandler());

        // Initialize document
        Document document = new Document(pdf);

        Paragraph p = new Paragraph("List of reported UFO sightings in 20th century")
                .setTextAlignment(TextAlignment.CENTER).setFont(helveticaBold).setFontSize(14);
        document.add(p);

        Table table = new Table(UnitValue.createPercentArray(new float[]{3, 5, 7, 4}));

        BufferedReader br = new BufferedReader(new FileReader(DATA));
        String line = br.readLine();
        process(table, line, helveticaBold, true);
        while ((line = br.readLine()) != null) {
            process(table, line, helvetica, false);
        }
        br.close();

        document.add(table);

        document.close();
    }

    public void process(Table table, String line, PdfFont font, boolean isHeader) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreTokens()) {
            if (isHeader) {
                table.addHeaderCell(new Cell()
                        .add(new Paragraph(tokenizer.nextToken())
                        .setFont(font)).setFontSize(9)
                        .setBorder(new SolidBorder(ColorConstants.BLACK, 0.5f)));
            } else {
                table.addCell(new Cell()
                        .add(new Paragraph(tokenizer.nextToken())
                        .setFont(font)).setFontSize(9)
                        .setBorder(new SolidBorder(ColorConstants.BLACK, 0.5f)));
            }
        }
    }


    protected class MyEventHandler implements IEventHandler {

        public void handleEvent(Event event) {
            PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
            PdfDocument pdfDoc = docEvent.getDocument();
            PdfPage page = docEvent.getPage();
            int pageNumber = pdfDoc.getPageNumber(page);
            Rectangle pageSize = page.getPageSize();
            PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDoc);

            //Set background
            Color limeColor = new DeviceCmyk(0.208f, 0, 0.584f, 0);
            Color blueColor = new DeviceCmyk(0.445f, 0.0546f, 0, 0.0667f);
            pdfCanvas.saveState()
                    .setFillColor(pageNumber % 2 == 1 ? limeColor : blueColor)
                    .rectangle(pageSize.getLeft(), pageSize.getBottom(), pageSize.getWidth(), pageSize.getHeight())
                    .fill().restoreState();

            //Add header and footer
            pdfCanvas.beginText()
                    .setFontAndSize(helvetica, 9)
                    .moveText(pageSize.getWidth() / 2 - 60, pageSize.getTop() - 20)
                    .showText("THE TRUTH IS OUT THERE")
                    .moveText(60, -pageSize.getTop() + 30)
                    .showText(String.valueOf(pageNumber))
                    .endText();

            //Add watermark
            Canvas canvas = new Canvas(pdfCanvas, page.getPageSize());
            canvas.setFontColor(ColorConstants.WHITE);
            canvas.setProperty(Property.FONT_SIZE, UnitValue.createPointValue(60));
            canvas.setProperty(Property.FONT, helveticaBold);
            canvas.showTextAligned(new Paragraph("CONFIDENTIAL"), 298, 421, pdfDoc.getPageNumber(page),
                    TextAlignment.CENTER, VerticalAlignment.MIDDLE, 45);

            pdfCanvas.release();
        }
    }
}
