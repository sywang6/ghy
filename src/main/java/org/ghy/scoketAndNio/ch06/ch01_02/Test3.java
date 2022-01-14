package org.ghy.scoketAndNio.ch06.ch01_02;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

//获取通道文件给定区域的锁
//test case 1: 先运行Test3在运行Test4
//test case 1: 先运行Test3在运行Test5
public class Test3 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("F:\\var\\060102_Test3.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            //锁定文件的一部分区域
            Future<FileLock> future = channel.lock(0,3,false);
            FileLock lock = future.get();
            System.out.println("A get lock time="+System.currentTimeMillis());
            Thread.sleep(20000);
            lock.release();
            System.out.println("A release lock time="+System.currentTimeMillis());
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
