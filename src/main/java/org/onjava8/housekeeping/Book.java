package org.onjava8.housekeeping;

public class Book {
    boolean checkedOut = false;
    Book(boolean checkOut) {
        checkedOut = checkOut;
    }
    void checkIn() {
        checkedOut = false;
    }
    @Override
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("Error: checked out");
        }
// Normally, you'll also do this:
//super.finalize(); // Call the base-class version
    }
}
