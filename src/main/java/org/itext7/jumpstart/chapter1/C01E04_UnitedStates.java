package org.itext7.jumpstart.chapter1;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import org.itext7.jumpstart.AabsolutePath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class C01E04_UnitedStates {

    public static final String DATA = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/data/united_states.csv";

    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH +"results/chapter01/united_states.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C01E04_UnitedStates().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        //设置纸张大小,A4
        Document document = new Document(pdf, PageSize.A4.rotate());
        //页边距
        document.setMargins(20, 20, 20, 20);
        //字体
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        //列宽,第一列是第二列的4倍,第三列是第二列的3倍
        Table table = new Table(UnitValue.createPercentArray(new float[]{4, 1, 3, 4, 3, 3, 3, 3, 1}))
        //表格占页面大小(不包含页边距)的百分比:useAllAvailableWidth()与table.setWidth(100)效果一致,表格占页面大小的100%
        .useAllAvailableWidth();
        //table.setWidth(100);
        BufferedReader br = new BufferedReader(new FileReader(DATA));
        String line = br.readLine();
        process(table, line, bold, true);
        while ((line = br.readLine()) != null) {
            process(table, line, font, false);
        }
        br.close();
        document.add(table);

        //Close document
        document.close();
    }

    public void process(Table table, String line, PdfFont font, boolean isHeader) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreTokens()) {
            if (isHeader) {
                table.addHeaderCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            } else {
                table.addCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            }
        }
    }

}
