package org.ghy.scoketAndNio.ch05.ch08_15;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

//对通道执行close()方法后的效果.
//关闭某个键的通道,通道对应的键都被添加到其选择器的已取消键集中,会导致在下一次select()方法选择操作期间注销该键的通道,而
//在注销是将从所有选择器的键集中移除该键
public class Test2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
        serverSocketChannel1.bind(new InetSocketAddress("localhost",7777));
        serverSocketChannel1.configureBlocking(false);

        ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
        serverSocketChannel2.bind(new InetSocketAddress("localhost",8888));
        serverSocketChannel2.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey selectionKey1 = serverSocketChannel1.register(selector,SelectionKey.OP_ACCEPT);
        SelectionKey selectionKey2 = serverSocketChannel2.register(selector,SelectionKey.OP_ACCEPT);
        Thread client = new Thread(){
          public void run(){
              try {
                  Socket socket1 = new Socket("localhost",7777);
                  OutputStream outputStream1 = socket1.getOutputStream();
                  outputStream1.write("我是中国人,我来自客户端to7777!".getBytes());
                  socket1.close();

                  Socket socket2 = new Socket("localhost",8888);
                  OutputStream outputStream2 = socket2.getOutputStream();
                  outputStream2.write("我是中国人,我来自客户端同8888!".getBytes());
                  socket2.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        };
        client.start();
        Thread getInfo = new Thread(){
          public void run(){
              try {
                  Thread.sleep(10000);
                  System.out.println();
                  Set<SelectionKey> keys = selector.keys();
                  Set<SelectionKey> selectionKeys = selector.selectedKeys();
                  System.out.println("channel.close之后的信息:");
                  System.out.println("keys.size()="+keys.size());
                  System.out.println("selectedKeys.size()="+selectionKeys.size());
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };
        getInfo.start();

        Thread.sleep(1000); //先让客户端连接到服务器

        boolean isRun =  true;
        while (isRun == true){
            int keyCount = selector.select();
            Set<SelectionKey> keys = selector.keys();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("channel.close()之前的信息:");
            System.out.println("keys.size()="+keys.size());
            System.out.println("selectionKeys.size()="+selectionKeys.size());
            System.out.println();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                    ServerSocket serverSocket = channel.socket();
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    byte[] byteArray = new byte[1000];
                    int readLength = inputStream.read(byteArray);
                    while (readLength != -1){
                        String newString = new String(byteArray,0 ,readLength);
                        System.out.println(newString);
                        readLength = inputStream.read(byteArray);
                    }
                    inputStream.close();
                    socket.close();
                    if (serverSocket.getLocalPort() == 7777){
                        channel.close();
                    }
                }
            }
        }
        serverSocketChannel1.close();
        serverSocketChannel2.close();
    }
}
















