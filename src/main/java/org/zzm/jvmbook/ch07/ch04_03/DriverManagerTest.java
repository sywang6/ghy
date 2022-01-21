package org.zzm.jvmbook.ch07.ch04_03;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerTest {
    public static void main(String[] args) throws SQLException {
        Driver driver = DriverManager.getDriver("jdbc:mysql://172.16.16.8:3306/heg?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&connectTimeout=10000");
        //java.sql.Driver和java.sql.DriverManager是由启动类加载器加载的,毫无疑问
        System.out.println(Driver.class.getClassLoader());
        System.out.println(DriverManager.class.getClassLoader());
        System.out.println(driver.getClass().getName());
        //DriverManager的静态代码块loadInitialDrivers();还触发了com.mysql.cj.jdbc.Driver类的加载.
        //如果按双亲委派模型,com.mysql.cj.jdbc.Driver也应该由最顶层的启动类加载器加载,但是启动类加载器是不会加载
        //com.mysql.cj.jdbc.Driver类.因为com.mysql.cj.jdbc.Driver类不在<JAVA_HOME>/lib下面(即使在下面也不会加载,启动类加载器只会加载特定文件名的jar)
        //那怎么办?启动类加载器的逻辑已经在jvm实现里面写死了,那只能突破双亲委派模型了.不用启动类加载器区加载Driver的具体实现类,那用哪个类加载器呢?
        //稍微跟踪下代码就会发现,是从的Thread.currentThread().getContextClassLoader()获得的一个加载器(也就是常说的线程上下文加载器)去加载Driver的具体实现类
        System.out.println(driver.getClass().getClassLoader());
        //java.sql.Driver
        //null
        //com.mysql.cj.jdbc.Driver
        //sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
