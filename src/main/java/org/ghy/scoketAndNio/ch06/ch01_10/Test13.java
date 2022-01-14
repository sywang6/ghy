package org.ghy.scoketAndNio.ch06.ch01_10;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test13 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("F:\\var\\060110_Test13.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(3);
            //读取数据方式1
            Future<Integer> future = channel.read(buffer,0);
            System.out.println("length="+future.get());
            channel.close();
            byte[] byteArray = buffer.array();
            for (int i = 0; i < byteArray.length; i++) {
                System.out.print((char)byteArray[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
