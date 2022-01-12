package org.ghy.scoketAndNio.ch05.ch08_09;

import java.io.IOException;
import java.nio.channels.Selector;

public class Test18 {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            System.out.println(selector.isOpen());
            //关闭选择器会发送什么?
            selector.close();
            System.out.println(selector.isOpen());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
