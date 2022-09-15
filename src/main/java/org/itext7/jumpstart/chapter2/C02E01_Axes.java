package org.itext7.jumpstart.chapter2;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;

public class C02E01_Axes {
    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH +"results/chapter02/axes.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C02E01_Axes().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
        PageSize ps = PageSize.A4.rotate();
        PdfPage page = pdf.addNewPage(ps);
        PdfCanvas canvas = new PdfCanvas(page);
        /*坐标系,变换矩阵
          a   b   0
          c   d   0
          e   f   1
         */
        canvas.concatMatrix(1, 0, 0, 1, ps.getWidth() / 2, ps.getHeight() / 2);

        pdf.close();
    }

    public static void drawAxes(PdfCanvas canvas, PageSize ps){
        //1.Draw X axis
        //画X轴 : (x1,y1)到(x2,y2)画了一条线,x的值为一半的页面宽度减15px表示离页面边缘有15px的间隙(页边距)
        canvas.moveTo(-(ps.getWidth() / 2-15 ), 0)
                .lineTo(ps.getWidth() / 2-15 , 0)
                .stroke();
        //2.Draw X axis arrow
        //画X轴箭头: >,
        // 首先设置了线条连接方式为:ROUND
        //接着画了两条线:(页宽一半-25,-10)到(页宽一半,0),(页宽一半,0)到(页宽一半-25,10)
        //恢复线条连接方式
        canvas.setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.ROUND)
                .moveTo(ps.getWidth() / 2 - 25, -10)
                .lineTo(ps.getWidth() / 2 - 15, 0)
                .lineTo(ps.getWidth() / 2 - 25, 10).stroke()
                .setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.MITER);

        //3.Draw Y axis
        //画Y轴:同样上下页边距为15px
        canvas.moveTo(0, -(ps.getHeight() / 2 - 15))
                .lineTo(0, ps.getHeight() / 2 - 15)
                .stroke();

        //4.Draw Y axis arrow
        //画Y轴箭头: ^
        //与x轴的箭头类似,也是画了两条线. 使用了saveState()保存现场,restoreState()来恢复现场
        canvas.saveState()
                .setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.ROUND)
                .moveTo(-10, ps.getHeight() / 2 - 25)
                .lineTo(0, ps.getHeight() / 2 - 15)
                .lineTo(10, ps.getHeight() / 2 - 25).stroke()
                .restoreState();

        //Draw X serif
        //画衬线
        for (int i = -((int) ps.getWidth() / 2 - 61); i < ((int) ps.getWidth() / 2 - 60); i += 40) {
            canvas.moveTo(i, 5).lineTo(i, -5);
        }
        //Draw Y serif
        //画衬线
        for (int j = -((int) ps.getHeight() / 2 - 57); j < ((int) ps.getHeight() / 2 - 56); j += 40) {
            canvas.moveTo(5, j).lineTo(-5, j);
        }
        canvas.stroke();
    }

}
