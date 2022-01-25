package org.syw.temp;

public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(cac()+""); // 1

    }
     public static int cac(){
        int i = 0;
        try{
            i = 1;
            return  i;
        }catch (Exception e){
            i = 10;
            return i;
        }finally {
            i =3;
        }
    }
}

