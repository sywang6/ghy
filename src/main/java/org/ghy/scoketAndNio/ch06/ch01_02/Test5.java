package org.ghy.scoketAndNio.ch06.ch01_02;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test5 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("F:\\var\\060102_Test3.txt");
            AsynchronousFileChannel channel =  AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            System.out.println("C lock begin "+System.currentTimeMillis());
            Future<FileLock> future = channel.lock(4,4,false);
            System.out.println("C lock end "+System.currentTimeMillis());
            FileLock lock = future.get();
            System.out.println("C get lock time="+System.currentTimeMillis());
            lock.release();
            channel.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
