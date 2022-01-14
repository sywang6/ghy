package org.ghy.scoketAndNio.ch06.ch01_07;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test11 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("F:\\var\\060107_Test11.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            System.out.println("begin time="+System.currentTimeMillis());
            //锁定部分区域,非共享,设置附加值,回调
            channel.lock(0, 3, false, "我是附加值", new CompletionHandler<FileLock, String>() {
                @Override
                public void completed(FileLock result, String attachment) {
                    try {
                        System.out.println("public void completed(FileLock result,String attachment) attachment="+attachment);
                        result.release();
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
            System.out.println(" end time="+System.currentTimeMillis());
            Thread.sleep(3000);
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
