package org.ghy.multiThreadCore.ch03.ch04_06;

/**
 * InheritableThreadLocal具有继承的特性
 */
public class Test {
    public static void main(String[] args) {
        try {
          UserInfo userInfo = new UserInfo();
          System.out.println("A userInfo "+ userInfo.hashCode());
          userInfo.setUsername("中国");
          if(Tools.t1.get()==null){
              Tools.t1.set(userInfo);
          }
          System.out.println(" 在main线程中取值="+ userInfo.getUsername()+" "+userInfo.hashCode());
          Thread.sleep(100);
          ThreadA a = new ThreadA();
          a.start();
          Thread.sleep(5000);
          Tools.t1.get().setUsername("美国");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
