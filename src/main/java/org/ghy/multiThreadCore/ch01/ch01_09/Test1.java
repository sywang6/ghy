package org.ghy.multiThreadCore.ch01.ch01_09;

import java.util.Map;

/**
 * 获取jvm所有线程的堆栈信息
 */
public class Test1 {


    public void e(){

        Map<Thread, StackTraceElement[]>    map =  Thread.getAllStackTraces();

        map.forEach((k,v)->{
        System.out.println("------线程基本信息-------");
        System.out.println("线程名称:"+k .getName());
        System.out.println("线程状态:"+k.getState());
        System.out.println("线程堆栈信息:");
        for(int i=0;i<v.length;i++){
            StackTraceElement eachElement = v[i];
            System.out.println("className:"+eachElement.getClassName()+" methodName:"+eachElement.getMethodName()+
                        " fileName:"+ eachElement.getFileName()+" lineNumber:"+eachElement.getLineNumber());
        }
        System.out.println("------end------");
            System.out.println();
        });


    }


    public static void main(String[] args){

        Test1 test1 = new Test1();

        test1.e();

    }


}
