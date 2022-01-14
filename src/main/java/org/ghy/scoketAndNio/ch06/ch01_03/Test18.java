package org.ghy.scoketAndNio.ch06.ch01_03;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test18 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("F:\\var\\060103_Test17.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            System.out.println("lock begin "+System.currentTimeMillis());
            Future<FileLock> future = channel.lock(1,5,false);
            System.out.println("lock end "+System.currentTimeMillis());
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
