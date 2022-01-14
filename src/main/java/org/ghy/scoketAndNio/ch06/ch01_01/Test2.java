package org.ghy.scoketAndNio.ch06.ch01_01;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

//获得此通道文件的独占锁,先运行Test1,在运行Test2
public class Test2 {
    public static void main(String[] args) {
       //  F:\\var\\060101_Test1.txt
        try {
            Path path = Paths.get("F:\\var\\060101_Test1.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            System.out.println("B get lock time ="+System.currentTimeMillis());
            Future<FileLock> future = channel.lock();
            System.out.println("lock end ="+System.currentTimeMillis());
            FileLock lock = future.get();
            System.out.println("B release time="+System.currentTimeMillis());
            lock.release();
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
