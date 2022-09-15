package org.itext7.jumpstart.chapter4;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;
import java.util.Map;
/**
 * Simple filling out form example.
 * 填充已经存在的表单
 */
public class C04E04_FillForm {
    public static final String SRC = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/pdf/job_application.pdf";
    public static final String DEST =AabsolutePath.PROJECT_ROOR_PATH + "results/chapter04/fill_form.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C04E04_FillForm().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfReader(src), new PdfWriter(dest));


        PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
        Map<String, PdfFormField> fields = form.getFormFields();
        fields.get("name").setValue("James Bond");
        fields.get("language").setValue("English");
        fields.get("experience1").setValue("Off");
        fields.get("experience2").setValue("Yes");
        fields.get("experience3").setValue("Yes");
        fields.get("shift").setValue("Any");
        fields.get("info").setValue("I was 38 years old when I became an MI6 agent.");

        pdf.close();

    }

    }
