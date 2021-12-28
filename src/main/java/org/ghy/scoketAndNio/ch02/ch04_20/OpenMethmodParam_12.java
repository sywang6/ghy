package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_12 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_11.txt");
        Path path = file.toPath();
        //DSYNC也是强制刷盘选项,效率急剧下降.与SYNC不同是DSYNC只有文件内容更新了才触发强制刷盘,而SYNC文件内容或文件元数据(比如文件最后
        // 更新时间)更新了都触发
        //强制刷盘
        FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.WRITE,StandardOpenOption.CREATE
        ,StandardOpenOption.DSYNC);
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            fileChannel.write(ByteBuffer.wrap("b".getBytes()));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
       fileChannel.close();
    }
}
