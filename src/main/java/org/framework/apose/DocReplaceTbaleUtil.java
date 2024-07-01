package org.framework.apose;

import org.apache.poi.xwpf.usermodel.*;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DocReplaceTbaleUtil {

    public static void main(String[] args) throws IOException {
        List<Map<String, Object>> dataList = new LinkedList<>();
        for (int i = 0; i <10 ; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("列1","a"+i);
            map.put("列2","b"+i);
            map.put("列3","b"+i);
            dataList.add(map);
        }
        doTable(0, dataList);


    }


    /**
     * @Method doTable
     * @Description 替换表格内容
     * @param index（表格索引：第几个表格），dataMap（数据源）
     * @Return void
     * @Exception
     */
    public static void  doTable(int index, List<Map<String, Object>> dataMap) throws  IOException {
        File tpl = new File(AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/doc/template.docx");
        if(!tpl.exists()){ //模板文件不存在
           throw new RuntimeException("模板文件不存在");
        }
            //读取模板文件
            FileInputStream is = new FileInputStream(tpl);
            XWPFDocument xwpfDocument = new XWPFDocument(is);
            //使用xwpfDocument对象操作word文档
        XWPFTable table = xwpfDocument.getTables().get(index);
        if (dataMap == null && dataMap.size() <= 0) {
            throw new RuntimeException("没有需要填充的内容");
        }
            List<XWPFTableRow> rows = table.getRows();
            int rowIndex = 0;//寻找字段绑定行索引
            String[] fields = null;////字段绑定行字段顺序（a,b,c）
            for (XWPFTableRow row : rows) {
                List<XWPFTableCell> cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    String key = cell.getText()
                            .replaceAll("\\{", "")
                            .replaceAll("}", "");

                    if (dataMap.get(0).get(key) != null) {//找到匹配
                        fields = new String[cells.size()];
                        break;
                    }
                }
                if (fields != null && fields.length>0) {//找到,并获取字段
                    for(int i=0;i<fields.length;i++){
                        fields[i] = cells.get(i)
                                .getText()
                                .replaceAll("\\{", "")
                                .replaceAll("}", "");
                    }
                    break;
                }else {
                    rowIndex++;
                }
            }
            if (rowIndex >= 0 && fields != null) {
                //从字段绑定行开始插入
                for (Map<String, Object> rowdata : dataMap) {
                    XWPFTableRow row = null;
                    try {
                        row = rows.get(rowIndex);
                    } catch (Exception e) {
                        row = table.createRow();
                    }
                    if(row != null) {
                        List<XWPFTableCell> cells = row.getTableCells();
                        int cellIndex = 0;
                        for (XWPFTableCell cell : cells) {
                            cell.removeParagraph(0);
                            XWPFParagraph newPara=cell.addParagraph();
                            XWPFRun run=newPara.createRun();

                            Object value = rowdata.get(fields[cellIndex]);
                            if(value != null){
                                run.setText(value.toString());
                            }

                            cellIndex++;
                        }
                    }
                    rowIndex++;
                }
            }


        FileOutputStream out = new FileOutputStream(AabsolutePath.PROJECT_ROOR_PATH + "results/poi/替换表格.docx");
        xwpfDocument.write(out);
        out.close();

    }

}
