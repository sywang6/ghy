package org.zzm.jvmbook.ch07.ch04_01;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader myLoader = new ClassLoader(){
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return  super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw  new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("org.zzm.jvmbook.ch07.ch04_01.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass().getName());
        System.out.println(obj instanceof org.zzm.jvmbook.ch07.ch04_01.ClassLoaderTest);
        //输出:
        //org.zzm.jvmbook.ch07.ch04_01.ClassLoaderTest
        //false
        //分析:
        //obj确实是ClassLoaderTest的一个实例,但是instanceof确返回false,这是由于java虚拟机中有两个ClassLoaderTest类,一个由应用程序类加载器加载
        //一个由我们自定义的类加载器加载
    }
}
