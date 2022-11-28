package org.itext7.jumpstart.util;

import com.itextpdf.kernel.font.PdfFont;

import java.util.Map;

public class OverTextDTO {
    private Map<String, String> replaceMap;
    private String sourceFilePath;
    private String finishFilePath;
    private PdfFont font;

    public Map<String, String> getReplaceMap() {
        return replaceMap;
    }

    public void setReplaceMap(Map<String, String> replaceMap) {
        this.replaceMap = replaceMap;
    }

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    public String getFinishFilePath() {
        return finishFilePath;
    }

    public void setFinishFilePath(String finishFilePath) {
        this.finishFilePath = finishFilePath;
    }

    public PdfFont getFont() {
        return font;
    }

    public void setFont(PdfFont font) {
        this.font = font;
    }
}
