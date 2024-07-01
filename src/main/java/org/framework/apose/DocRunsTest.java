package org.framework.apose;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class DocRunsTest {
    public static void main(String[] args) throws IOException {
        File tpl = new File(AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/doc/DocRunsTest.docx");
        if(!tpl.exists()){ //模板文件不存在
            throw new RuntimeException("模板文件不存在");
        }
        //读取模板文件
        FileInputStream is = new FileInputStream(tpl);
        XWPFDocument xwpfDocument = new XWPFDocument(is);
        List<XWPFParagraph>  paragraphs = xwpfDocument.getParagraphs();
        paragraphs.forEach(xwpfParagraph -> {
            List<XWPFRun> runs =   xwpfParagraph.getRuns();
            runs.forEach(xwpfRun -> {
                System.out.println(xwpfRun.toString());
                System.out.println(xwpfRun.getFontFamily()+" "+xwpfRun.getFontSize()+" "+xwpfRun.isBold()+" "+xwpfRun.getUnderline());
            });
            System.out.println("==========================");
            List<XWPFRun>  newRuns =   replaceText(xwpfParagraph);
            newRuns.forEach(xwpfRun -> {
                System.out.println(xwpfRun.toString());
                System.out.println(xwpfRun.getFontFamily()+" "+xwpfRun.getFontSize()+" "+xwpfRun.isBold()+" "+xwpfRun.getUnderline());
            });

        });
    }

    private static List<XWPFRun> replaceText(XWPFParagraph para) {
        List<XWPFRun> runs = para.getRuns();
        String str = "";
        boolean flag = false;
        for (int i = 0; i < runs.size(); i++) {
            XWPFRun run = runs.get(i);
            String runText = run.toString();
            //获得每个run的文本

            if (flag || runText.equals("${")) {
                str = str + runText;
                flag = true;

                para.removeRun(i);
                if (runText.equals("}")) {
                    flag = false;
                    para.insertNewRun(i).setText(str);
                    str = "";
                }
                i--;
            }
        }
        return runs;
    }
}


