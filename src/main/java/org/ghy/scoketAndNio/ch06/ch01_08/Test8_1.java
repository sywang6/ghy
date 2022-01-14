package org.ghy.scoketAndNio.ch06.ch01_08;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//先运行Test8_1在运行Test8_2
public class Test8_1 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("F:\\var\\060108_Test8_1.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            System.out.println("A begin time="+System.currentTimeMillis());
            channel.lock("我是附件值A", new CompletionHandler<FileLock, String>() {
                @Override
                public void completed(FileLock result, String attachment) {
                    try {
                        Thread.sleep(30000);
                        result.release();
                        System.out.println("A release lock time="+System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Throwable exc, String attachment) {
                    System.out.println("public void failed(Throwable exc,String attachment) attachment="+attachment);
                    System.out.println("getMessage="+exc.getMessage());
                }
            });
            System.out.println("A end time="+System.currentTimeMillis());
            Thread.sleep(10000);
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
