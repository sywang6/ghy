package org.framework.apose;

import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.*;
import org.itext7.jumpstart.AabsolutePath;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;

import java.io.*;
import java.lang.reflect.Field;
import java.util.List;

public class DocForHeader {
    public DocForHeader() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        File tpl = new File(AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/doc/池保理合同（模板）-制作.docx");
        if(!tpl.exists()){ //模板文件不存在
            throw new RuntimeException("模板文件不存在");
        }
        //读取模板文件
        FileInputStream is = new FileInputStream(tpl);
        XWPFDocument doc = new XWPFDocument(is);

        //获取页眉，判断页眉是否为空
        List<XWPFHeader> pageHeaders = doc.getHeaderList();

        //若判断合同没有页眉时
        if(pageHeaders.isEmpty()) {
            //生成首页页眉
            XWPFParagraph paragraph=doc.createHeader(HeaderFooterType.FIRST).createParagraph();
            XWPFRun run =paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run.setText("我是一个首页页眉");
            run.setFontFamily("C39HrP24DlTt");//设置页眉字体,这里是条形码字体

            //生成偶数页的页眉
            paragraph=doc.createHeader(HeaderFooterType.EVEN).createParagraph();
            run =paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.LEFT);
            run.setText("我是与首页页眉不一样的其它页页眉");
            run.setFontSize(8);//设置页眉字体大小

            //生成奇数页的页眉
            paragraph=doc.createHeader(HeaderFooterType.DEFAULT).createParagraph();
            run =paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.LEFT);
            run.setText("我是与首页页眉不一样的其它页页眉");//其它页页眉内容与首页不同，但奇数页和偶数页要单独设置成一样的内容

            Field filedSet = XWPFDocument.class.getDeclaredField("settings");
            filedSet.setAccessible(true);
            XWPFSettings xwpfsettings = (XWPFSettings)filedSet.get(doc);

            Field filedCtSet = XWPFSettings.class.getDeclaredField("ctSettings");
            filedCtSet.setAccessible(true);
            CTSettings ctSettings =(CTSettings)filedCtSet.get(xwpfsettings);
            ctSettings.addNewEvenAndOddHeaders();
        }else {
            //当合同文本有页眉时，内容不为空，将原内容进行替换
            for(XWPFHeader pageHeader : pageHeaders){
                List<XWPFParagraph> paragraphs = pageHeader.getParagraphs();
                for(XWPFParagraph paragraph : paragraphs){
                    List<XWPFRun> runs = paragraph.getRuns();

                    //合同有页眉，但是内容可能为空，对照上面第2 点
                    if(!runs.isEmpty()) {
                        for(int i=0;i<runs.size();i++){
                            XWPFRun run = runs.get(i);
                            run.setText("我是一个页眉，我要替换本来的页眉",0);
                            paragraph.setAlignment(ParagraphAlignment.RIGHT);//设置页眉左对齐
                        }
                    }else {
                        //生成首页页眉
                        XWPFParagraph paragraph2=doc.createHeader(HeaderFooterType.FIRST).createParagraph();
                        XWPFRun run =paragraph2.createRun();
                        paragraph2.setAlignment(ParagraphAlignment.CENTER);//设置页眉居中
                        run.setText("我是一个首页页眉");
                        run.setFontFamily("C39HrP24DlTt");

                        //生成偶数页的页眉
                        paragraph2=doc.createHeader(HeaderFooterType.EVEN).createParagraph();
                        run =paragraph2.createRun();
                        paragraph2.setAlignment(ParagraphAlignment.LEFT);
                        run.setText("我是与首页页眉不一样的其它页页眉");
                        run.setFontSize(8);

                        //生成奇数页的页眉
                        paragraph2=doc.createHeader(HeaderFooterType.DEFAULT).createParagraph();
                        run =paragraph2.createRun();
                        paragraph2.setAlignment(ParagraphAlignment.LEFT);
                        run.setText("我是与首页页眉不一样的其它页页眉");

                        Field filedSet = XWPFDocument.class.getDeclaredField("settings");
                        filedSet.setAccessible(true);
                        XWPFSettings xwpfsettings = (XWPFSettings)filedSet.get(doc);

                        Field filedCtSet = XWPFSettings.class.getDeclaredField("ctSettings");
                        filedCtSet.setAccessible(true);
                        CTSettings ctSettings =(CTSettings)filedCtSet.get(xwpfsettings);
                        ctSettings.addNewEvenAndOddHeaders();
                        //此处一定要断开循环

                        break;


                    }
                }
            }
        }
        FileOutputStream out = new FileOutputStream(AabsolutePath.PROJECT_ROOR_PATH + "results/poi/池保理合同（模板）-制作-header.docx");
        doc.write(out);
        out.close();
    }

}
