package org.itext7.jumpstart.util;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import org.itext7.jumpstart.AabsolutePath;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReplaceUtilsTest {
    public static void main(String[] args) throws IOException {
        OverTextDTO overTextDTO = new OverTextDTO();
        Map<String,String> map = new HashMap<>();
        map.put("88TH","89TH");
        map.put("88th","89th");
        overTextDTO.setSourceFilePath(AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/pdf/88th_noms_announcement.pdf");
        overTextDTO.setFinishFilePath(AabsolutePath.PROJECT_ROOR_PATH + "results/util/89th_noms_announcement.pdf");
        overTextDTO.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        overTextDTO.setReplaceMap(map);
        ReplaceUtils.doOverText(overTextDTO);
    }
}
