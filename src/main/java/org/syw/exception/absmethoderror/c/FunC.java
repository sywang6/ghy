package org.syw.exception.absmethoderror.c;


import org.syw.exception.absmethoderror.a.IFunc;
import org.syw.exception.absmethoderror.b.FunB;

public class FunC implements IFunc {

    public void method() {
        System.out.println("FunC.method()");
    }


    public void aNewMethod() {
        System.out.println("FunC.aNewMethod()");
    }

    public static void main(String[] args) {
        IFunc func = new FunB();
        func.aNewMethod();
    }

}
