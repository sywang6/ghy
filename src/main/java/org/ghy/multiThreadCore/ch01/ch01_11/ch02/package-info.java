/**
 * 线程中断相关的知识:
 * Thread类的两个方法:
 * public static boolean interrupted()
 * 与
 * public boolean isInterrupted()
 *
 * 1.
 *interrupted()是一个静态方法,看下这个方法的实现,
 * public static boolean interrupted() {
 *         return currentThread().isInterrupted(true);
 *     }
 *判断当前线程有没有被中断,如果中断了返回true,并且会清除当前线程的中断标记
 *
 * 2.
 * isInterrupted()是一个实例方法,判断实例所代表的线程有没有被中断,并且不会清除中断标记
 *
 *
 * 线程就是工厂干活的工人,工人有个特殊的福利:每个人都有一块牌子,上面写着是否暂停手头的活.
 *
 * 把自己当成正在干活的工人,Thread.interrupted()就是取看下自己的牌子,是不是暂停手头的活,一看是要暂停,那就不干活了,并且还要把牌子的的状态改成要继续干活
 * .
 * 线程实例引用.isInterrupted()就是看看实例所代表的人要不要暂停手头的活,仅仅是看看,不改变要不要继续干活的状态.
 *
 *
 *
 */
package org.ghy.multiThreadCore.ch01.ch01_11.ch02;