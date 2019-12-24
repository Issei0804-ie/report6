package jp.ac.uryukyu.ie.e195755;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Server {
    ServerSocket ssocket = null;
    Socket socket = null;

    public Server(int port) {
        // portの設定
        InetSocketAddress address = new InetSocketAddress(port);

        //指定されたポートにbindを行う。
        try {
            ssocket = new ServerSocket(port);
            System.out.println("Bind ok");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public int listen() {

        try{
            System.out.println("wait client");
            socket = ssocket.accept();
            System.out.println("connect client");
            return 1;
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
        System.out.println("wait client");
        while (true) {

        }
    }
    public void read(){
        try{
            InputStream input =  socket.getInputStream();
            System.out.println(input.read());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
