package org.ghy.scoketAndNio.ch06.ch01_12;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test15 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("F:\\var\\060112_Test15.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE,StandardOpenOption.CREATE);
            ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
            Future<Integer> future = channel.write(buffer,channel.size());
            System.out.println("length="+future.get());
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
