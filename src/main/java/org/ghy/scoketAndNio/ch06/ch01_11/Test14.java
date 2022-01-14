package org.ghy.scoketAndNio.ch06.ch01_11;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test14 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("F:\\var\\060111_Test14.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(3);
        channel.read(buffer, 0, "我是附加的参数", new CompletionHandler<Integer, String>() {
            @Override
            public void completed(Integer result, String attachment) {
                System.out.println("public void completed(Integer result,String attachment) result="+result
                +" attachment="+attachment);
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("public void failed(Throwable exc,String attachment) attachment="+attachment);
                System.out.println("getMessage="+exc.getMessage());
            }
        });
        channel.close();
       Thread.sleep(2000);
        byte[] byteArray = buffer.array();
        for (int i = 0; i < byteArray.length; i++) {
            System.out.println((char)byteArray[i]);
        }
    }
}
