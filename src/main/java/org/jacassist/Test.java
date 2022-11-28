package org.jacassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Test {
    public static void main(String[] args) {
        testMod_words1();
    }


    public static void testMod_words1(){
        try {
            ClassPool.getDefault().insertClassPath("C:\\dev\\repo\\com\\aspose\\aspose-words\\22.11\\aspose-words-22.11-jdk17.jar");

            CtClass zzZJJClass = ClassPool.getDefault().getCtClass("com.aspose.words.zzW93");
            CtMethod methodB = zzZJJClass.getDeclaredMethod("zzgp");
            methodB.setBody("{return true;}");
            zzZJJClass.writeFile("/Users/dengbp/Downloads/");
        } catch (Exception e) {
            System.out.println("错误==" + e);
        }
    }
}
