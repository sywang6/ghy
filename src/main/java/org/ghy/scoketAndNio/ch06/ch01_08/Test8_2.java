package org.ghy.scoketAndNio.ch06.ch01_08;

import org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg1onePoneC4value.C;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test8_2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        Path path = Paths.get("F:\\var\\060108_Test8_1.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("B begin time="+System.currentTimeMillis());
        channel.lock("我是附件值B", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    //等Test8_1释放锁之后,才能获得锁,执行回调
                    System.out.println("B public void completed(FileLock result,String attachment) attachment="+attachment);
                    result.release();
                    System.out.println("B get lock time="+System.currentTimeMillis());
                    result.release();
                    channel.close();
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
        System.out.println("B end time="+System.currentTimeMillis());
        Thread.sleep(50000);
    }
}
