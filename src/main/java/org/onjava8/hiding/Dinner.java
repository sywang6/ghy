package org.onjava8.hiding;

import org.onjava8.hiding.cookie.Cookie;

public class Dinner {
    public static void main(String[] args) {
        Cookie x = new Cookie();
// -x.bite(); // Can't access
    }
}
