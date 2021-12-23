package org.ghy.scoketAndNio.ch02.ch02_01;

public class DBOperate implements  AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("关闭连接");
    }
}
