package jp.ac.uryukyu.ie.e195755;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {
    Socket socket = new Socket();
    public Server(int port){
        // portの設定
        InetSocketAddress address = new InetSocketAddress(port);

        //指定されたポートにbindを行う。
        try{
            socket.bind(address);
        }catch(java.io.IOException e){
            e.printStackTrace();
        }
    }
    public void listen(){
        while (true) {

        }
    }
}

