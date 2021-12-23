package org.ghy.scoketAndNio.ch02.ch02_01;

public class Test {
    public static void main(String[] args) {
        //如果try后的小括号中有多条语句,则最后一条是没有分号的
        //并且小括号中的变量都要实现AutoCloseable接口
        try(DBOperate dbo = new DBOperate()){
            System.out.println("使用"+dbo+"开始数据库的操作");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
