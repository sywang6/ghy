package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_5 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_5.txt");
        Path path = file.toPath();
        //以写入访问打开时,添加TRUNCATE_EXISTING操作,会清空然来已写入的内容,随后从0处开始写入.不能与APPEND操作同时存在.
        //APPEND表示追加写入,一个要从头开始写一个要从末尾追加写入,明显冲突啦
        FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
        fileChannel.write(ByteBuffer.wrap("abcde".getBytes()));
        fileChannel.close();
    }
}
