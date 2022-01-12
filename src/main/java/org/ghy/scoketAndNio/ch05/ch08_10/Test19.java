package org.ghy.scoketAndNio.ch05.ch08_10;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

//获取Selector的提供者
public class Test19 {
    public static void main(String[] args) {
        try {
            SelectorProvider provider1 = SelectorProvider.provider();
            SelectorProvider provider2 = Selector.open().provider();
            System.out.println(provider1);
            System.out.println(provider2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
