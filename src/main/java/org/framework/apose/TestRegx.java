package org.framework.apose;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegx {
    public static void main(String[] args) {
        String  str  = "${ffff}";
        Matcher matcher = null;
        while ((matcher = matcher(str)).find()) {
            System.out.println(matcher.group(1));
           // fontType = matcher.group(1);
            //runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
        }
    }

    private static Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }
}
