package org.ghy.scoketAndNio.ch04.section01.ch01_12;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try {
            //ServerSocket对象创建完成,就已经监听了端口,可以接受连接,而不用等执行accept方法
            ServerSocket serverSocket = new ServerSocket(8088);
            Thread.sleep(Integer.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//No.	Time	Source	Destination	Protocol	Length	Info
//1	0.000000	127.0.0.1	127.0.0.1	TCP	56	49242 → 8088 [SYN] Seq=0 Win=65535 Len=0 MSS=65495 WS=256 SACK_PERM=1
//2	0.000039	127.0.0.1	127.0.0.1	TCP	56	8088 → 49242 [SYN, ACK] Seq=0 Ack=1 Win=65535 Len=0 MSS=65495 WS=256 SACK_PERM=1
//3	0.000065	127.0.0.1	127.0.0.1	TCP	44	49242 → 8088 [ACK] Seq=1 Ack=1 Win=2619648 Len=0
//4	0.000385	127.0.0.1	127.0.0.1	TCP	54	49242 → 8088 [PSH, ACK] Seq=1 Ack=1 Win=2619648 Len=10 [TCP segment of a reassembled PDU]
//5	0.000396	127.0.0.1	127.0.0.1	TCP	44	8088 → 49242 [ACK] Seq=1 Ack=11 Win=2619648 Len=0
//6	0.000549	127.0.0.1	127.0.0.1	TCP	54	49242 → 8088 [PSH, ACK] Seq=11 Ack=1 Win=2619648 Len=10 [TCP segment of a reassembled PDU]
//7	0.000557	127.0.0.1	127.0.0.1	TCP	44	8088 → 49242 [ACK] Seq=1 Ack=21 Win=2619648 Len=0
//8	0.000589	127.0.0.1	127.0.0.1	TCP	54	49242 → 8088 [PSH, ACK] Seq=21 Ack=1 Win=2619648 Len=10 [TCP segment of a reassembled PDU]
//9	0.000595	127.0.0.1	127.0.0.1	TCP	44	8088 → 49242 [ACK] Seq=1 Ack=31 Win=2619648 Len=0
//10	0.000666	127.0.0.1	127.0.0.1	TCP	44	49242 → 8088 [FIN, ACK] Seq=31 Ack=1 Win=2619648 Len=0
//11	0.000674	127.0.0.1	127.0.0.1	TCP	44	8088 → 49242 [ACK] Seq=1 Ack=32 Win=2619648 Len=0
