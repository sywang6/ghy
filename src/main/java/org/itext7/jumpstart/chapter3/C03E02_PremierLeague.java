package org.itext7.jumpstart.chapter3;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.renderer.CellRenderer;
import com.itextpdf.layout.renderer.DrawContext;
import org.itext7.jumpstart.AabsolutePath;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class C03E02_PremierLeague {
    public static final String DATA = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/data/premier_league.csv";
    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH +"results/chapter03/premier_league.pdf";

    Color greenColor = new DeviceCmyk(0.78f, 0, 0.81f, 0.21f);
    Color yellowColor = new DeviceCmyk(0, 0, 0.76f, 0.01f);
    Color redColor = new DeviceCmyk(0, 0.76f, 0.86f, 0.01f);
    Color blueColor = new DeviceCmyk(0.28f, 0.11f, 0, 0);

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C03E02_PremierLeague().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PageSize ps = new PageSize(842, 680);

        // Initialize document
        Document document = new Document(pdf, ps);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        //10列,i列的宽度为 ai*页面宽度/(a1+a2+...an)
        Table table = new Table(UnitValue.createPercentArray(new float[]{1.5f, 7, 2, 2, 2, 2, 3, 4, 4, 2}));
        //表格内容文本对齐
        table.setTextAlignment(TextAlignment.CENTER)
              //表格自身水平对对齐:居中
             .setHorizontalAlignment(HorizontalAlignment.CENTER);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(DATA), StandardCharsets.UTF_8));
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
        int columnNumber = 0;
        while (tokenizer.hasMoreTokens()) {
            //表头
            if (isHeader) {
                Cell cell = new Cell().add(new Paragraph(tokenizer.nextToken()));
                //使用自定义渲染器
                cell.setNextRenderer(new RoundedCornersCellRenderer(cell));
                //内边距5
                cell.setPadding(5)
                     //需显式设置边框为null,否则iText默认的边框会在画一次(自定义渲染器里面已经画了一次啦)
                    .setBorder(null);
                table.addHeaderCell(cell);
            } else {
                columnNumber++;
                Cell cell = new Cell().add(new Paragraph(tokenizer.nextToken()));
                cell.setFont(font)
                      //实线边框,黑色,0.5px
                     .setBorder(new SolidBorder(ColorConstants.BLACK, 0.5f));
                //列号不同,背景颜色不同
                switch (columnNumber) {
                    case 4:
                        cell.setBackgroundColor(greenColor);
                        break;
                    case 5:
                        cell.setBackgroundColor(yellowColor);
                        break;
                    case 6:
                        cell.setBackgroundColor(redColor);
                        break;
                    default:
                        cell.setBackgroundColor(blueColor);
                        break;
                }
                table.addCell(cell);
            }
        }
    }



    private class RoundedCornersCellRenderer extends CellRenderer {
        public RoundedCornersCellRenderer(Cell modelElement) {
            super(modelElement);
        }

        @Override
        public void drawBorder(DrawContext drawContext) {
            //BlockElement的边界
            Rectangle rectangle = getOccupiedAreaBBox();
            //左下角
            float llx = rectangle.getX() + 1;
            float lly = rectangle.getY() + 1;
            //右上角
            float urx = rectangle.getX() + getOccupiedAreaBBox().getWidth() - 1;
            float ury = rectangle.getY() + getOccupiedAreaBBox().getHeight() - 1;
            //画布
            PdfCanvas canvas = drawContext.getCanvas();
            float r = 4;
            float b = 0.4477f;
            //顶部圆角的矩形
            canvas.moveTo(llx, lly).lineTo(urx, lly).lineTo(urx, ury - r)
                    .curveTo(urx, ury - r * b, urx - r * b, ury, urx - r, ury)
                    .lineTo(llx + r, ury)
                    .curveTo(llx + r * b, ury, llx, ury - r * b, llx, ury - r)
                    .lineTo(llx, lly).stroke();
            super.drawBorder(drawContext);
        }
    }

}
