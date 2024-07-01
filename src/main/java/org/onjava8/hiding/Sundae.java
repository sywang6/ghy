package org.onjava8.hiding;

 class Sundae {
     private Sundae() {}
     static Sundae makeASundae() {
         return new Sundae();
     }
}
