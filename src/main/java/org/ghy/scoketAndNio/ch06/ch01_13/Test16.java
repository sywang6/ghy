package org.ghy.scoketAndNio.ch06.ch01_13;

import org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg1onePoneC4value.P;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test16 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("F:\\var\\060113_Test16.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        ByteBuffer buffer = ByteBuffer.wrap("abced".getBytes());
        channel.write(buffer, channel.size(), "我是附加的数据", new CompletionHandler<Integer, String>() {
            @Override
            public void completed(Integer result, String attachment) {
                System.out.println("public void completed(Integer result,String attachment) result="+result+" attachment="+attachment);
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("public void failed(Throwable exc,String attachment) attachment="+attachment);
                System.out.println("getMessage="+exc.getMessage());
            }
        });
        channel.close();
        Thread.sleep(2000);
    }
}
