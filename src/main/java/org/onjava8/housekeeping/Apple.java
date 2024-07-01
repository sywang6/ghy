package org.onjava8.housekeeping;

public class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}
