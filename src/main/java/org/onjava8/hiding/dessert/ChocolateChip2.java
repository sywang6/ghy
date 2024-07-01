package org.onjava8.hiding.dessert;


import org.onjava8.hiding.cookie2.Cookie;

public class ChocolateChip2 extends Cookie {
    public ChocolateChip2() {
        System.out.println("ChocolateChip constructor");
    }
    public void chomp() {
 bite(); // Can't access bite
    }
    public static void main(String[] args) {
        ChocolateChip2 x = new ChocolateChip2();
        x.chomp();
    }
}
