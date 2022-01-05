package org.ghy.scoketAndNio.ch05.ch07_05;

import java.io.IOException;
import java.nio.channels.Selector;

public class Test1 {
    public static void main(String[] args) {
        try {
            //获得selector对象
            Selector selector = Selector.open();
            System.out.println(selector);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
