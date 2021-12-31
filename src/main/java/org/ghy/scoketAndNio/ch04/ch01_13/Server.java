package org.ghy.scoketAndNio.ch04.ch01_13;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//每连接一线程,使用线程池
public class Server {

    private ServerSocket serverSocket;
    private Executor pool;

    public Server(int port, int poolSize) throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }
    public void startService(){
        try{
            for(;;){
                Socket socket = serverSocket.accept();
                pool.execute(new ReadRunnable(socket));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(8088,10000);
            server.startService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
