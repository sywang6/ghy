package org.ghy.scoketAndNio.ch06.ch01_06;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test9 {
    private static AsynchronousFileChannel channel;
    public static void main(String[] args) throws InterruptedException, IOException {
        Path path = Paths.get("F:\\var\\060106_Test9.txt");
        channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE,StandardOpenOption.READ);
        channel.close();
        channel.lock("我是字符串,我是附件", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    result.release();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //获取锁异常执行的方法
            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("public void failed(Throwable exc,String attachment)");
                System.out.println(("attachment="+attachment+" exc.getMessage()="+exc.getMessage()));
                System.out.println("exc.getClass().getName()="+exc.getClass().getName());
            }
        });
        Thread.sleep(3000);
    }
}
