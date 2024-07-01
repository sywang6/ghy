package org.syw.temp;

public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(cac()+"--主方法调用"); // 1

    }
     public static int cac(){
        int i = 0;
        try{
            i = 1;
            return  i;
        }catch (Exception e){
            i = 10;
            return i;
        //finally一定会执行
        }finally {
            System.out.println(i+"---finally---start");
            i =3;
            System.out.println(i+"---finally---end");
            return  i;
        }
    }
}

