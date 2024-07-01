package org.onjava8.control;

public class LabeledFor {
    public static void main(String[] args) {
        int i = 0;
        outer:
        // 此处不允许存在执行语句
        for (; true; ) { // 无限循环
            inner:
            // 此处不允许存在执行语句
            for (; i < 10; i++) {
                System.out.println("i = " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("break");
                    i++; // 否则i 永远无法获得自增
// 获得自增
                    break;
                }
                if (i == 7) {
                    System.out.println("continue outer");
                    i++; // 否则i 永远无法获得自增
// 获得自增
                    continue outer;
                }
                if (i == 8) {
                    System.out.println("break outer");
                    break outer;
                }
                for (int k = 0; k < 5; k++) {
                    if (k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
// 在此处无法break 或continue 标签
}
