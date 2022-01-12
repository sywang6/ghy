package org.ghy.scoketAndNio.ch05.ch08_15;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

//在新创建的选择器中,3个集合都是空集合
public class Test3 {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            Set<SelectionKey> keys = selector.keys();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            System.out.println("keys.size()="+keys.size());
            System.out.println("selectionKeySet.size()="+selectionKeySet.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
