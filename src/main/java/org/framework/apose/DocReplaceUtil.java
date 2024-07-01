package org.framework.apose;

import org.apache.poi.xwpf.usermodel.*;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocReplaceUtil {

    public static void main(String[] args) throws IOException {
        doTable();


    }

    /**
     * 编辑报表标题、填充的数据
     */
    private static Map<String, Object> editTitleAndFillData() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("externalContractNo", "2022第102号");
        params.put("firstCusMgrName", "firstCusMgrName");
        params.put("fillOrg", String.format("%-31s", "XXXX设计局"));
        params.put("fillYear", String.format("%-4s", "2021"));
        params.put("fillMonth", String.format("%-2s", "08"));
        params.put("fillDay", String.format("%-2s", "04"));
        params.put("fillUser", String.format("%-12s", "张华强"));
        params.put("fillPhone", String.format("%-11s", "13398764567"));
        return params;
    }



    /**
     * @Method doTable
     * @Description 替换表格内容
     * @Return void
     * @Exception
     */
    public static void  doTable() throws  IOException {
        File tpl = new File(AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/doc/池保理合同（模板）-制作.docx");
        if(!tpl.exists()){ //模板文件不存在
            throw new RuntimeException("模板文件不存在");
        }
        //读取模板文件
        FileInputStream is = new FileInputStream(tpl);
        XWPFDocument xwpfDocument = new XWPFDocument(is);
        replaceInPara(xwpfDocument, editTitleAndFillData());
       // replaceInHeader(xwpfDocument, editTitleAndFillData());
        FileOutputStream out = new FileOutputStream(AabsolutePath.PROJECT_ROOR_PATH + "results/poi/池保理合同（模板）-制作-填充.docx");
        xwpfDocument.write(out);
        out.close();

    }


    /**
     * 替换段落里面的变量
     * @param doc 要替换的文档
     * @param params 参数
     */
    public static void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
        for (XWPFParagraph para : doc.getParagraphs()) {
            replaceInPara(para, params);
        }
    }

    /**
     * 替换段落里面的变量
     * @param doc 要替换的文档
     * @param params 参数
     */
    public static void replaceInHeader(XWPFDocument doc, Map<String, Object> params) {
        for(XWPFHeader header: doc.getHeaderList()){
            //System.out.println(header.getText());//页眉
            for (XWPFParagraph para : header.getParagraphs()) {
                replaceInPara(para, params);
            }
        }
    }


    /**
     * 替换段落里面的变量
     * @param para 要替换的段落
     * @param params 参数
     */
    private static void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs = null;
        Matcher matcher = null;

        if (matcher(para.getParagraphText()).find()) {
            // 修正Run分割不准确的问题,确保${站位符}在一个Run里面
            runs = replaceText(para);
            for (int i = 0; i < runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                if("${firstSeal}".equals(runText)){

                    continue;
                }

               // String fontType = "";
                matcher = matcher(runText);
                if (matcher.find()) {
                    while ((matcher = matcher(runText)).find()) {
                       // fontType = matcher.group(1);
                            runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));

                    }
                    // 直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
                    // 所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
                    //记录每个run的字体,字体大小,是否加粗,是否有下划线
                    String fontFamily =  run.getFontFamily();
                    int fontSize=  run.getFontSize();
                    boolean isBold =  run.isBold();
                    UnderlinePatterns underlinePatterns =  run.getUnderline();
                    para.removeRun(i);
                    XWPFRun runX = para.insertNewRun(i);
                    runX.setFontFamily(fontFamily);
                    runX.setFontSize(fontSize);
                    runX.setBold(isBold);
                    runX.setUnderline(underlinePatterns);
                    runX.setText(runText);
                    // 设置字体样式
                }
            }
        }
    }



    /**
     * 修正Run分割不准确的问题,确保${站位符}在一个Run里面
     * @param para 要替换的段落
     * @return
     */
    private static List<XWPFRun> replaceText(XWPFParagraph para) {
        List<XWPFRun> runs = para.getRuns();
        String str = "";
        boolean flag = false;
        for (int i = 0; i < runs.size(); i++) {
            XWPFRun run = runs.get(i);
            String runText = run.toString();
           //记录每个run的字体,字体大小,是否加粗,是否有下划线
           String fontFamily =  run.getFontFamily();
            int fontSize=  run.getFontSize();
            boolean isBold =  run.isBold();
            UnderlinePatterns underlinePatterns =  run.getUnderline();
            if (flag || runText.equals("${")) {
                str = str + runText;
                flag = true;
                para.removeRun(i);
                if (runText.equals("}")) {
                    flag = false;
                    XWPFRun newRun =  para.insertNewRun(i);
                    newRun.setFontFamily(fontFamily);
                    newRun.setFontSize(fontSize);
                    newRun.setBold(isBold);
                    newRun.setUnderline(underlinePatterns);
                    newRun.setText(str);
                    str = "";
                }
                i--;
            }
        }
        return runs;
    }


    /**
     * 正则匹配字符串
     * @param str
     * @return
     */
    private static Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }


}
