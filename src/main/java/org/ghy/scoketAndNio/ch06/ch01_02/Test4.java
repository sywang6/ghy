package org.ghy.scoketAndNio.ch06.ch01_02;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test4 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("F:\\var\\060102_Test3.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            System.out.println("B lock begin "+System.currentTimeMillis());
            Future<FileLock> future = channel.lock(0,3,false);
            System.out.println("B lock end "+System.currentTimeMillis());
            FileLock lock = future.get();
            System.out.println("B get lock time="+System.currentTimeMillis());
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
