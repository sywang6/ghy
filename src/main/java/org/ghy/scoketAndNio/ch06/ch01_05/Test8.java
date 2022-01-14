package org.ghy.scoketAndNio.ch06.ch01_05;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test8 {
    public static void main(String[] args) throws InterruptedException, IOException {
        Path path = Paths.get("F:\\var\\060105_Test8.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("begin time="+System.currentTimeMillis());
        //CompletionHandler为获取锁成功之后的回调,可以肯定回调不是由主线程执行的
        channel.lock("我是附件值", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                    System.out.println("public void completed(FileLock result,String attachment) attachment="+attachment);
                    result.release();
                    channel.close();
                    System.out.println("release and close");
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("public void failed(Throwable exc, String attachment) attachment="+attachment);
                System.out.println("getMessage="+exc.getMessage());
            }
        });
        System.out.println(Thread.currentThread().getName());
        System.out.println("end time="+System.currentTimeMillis());
        Thread.sleep(3000);

    }
}
