package org.ghy.scoketAndNio.ch06.ch01_09;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//先运行Test11_1在运行Test11_2
public class Test11_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("F:\\var\\060109_Test11_1.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("A begin time="+System.currentTimeMillis());
        channel.lock(0, 3, false, "我是附加值A", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    Thread.sleep(20000);
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
    }
}
