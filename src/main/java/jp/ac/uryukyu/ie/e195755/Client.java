package jp.ac.uryukyu.ie.e195755;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

class Client {
    Socket socket = null;
    Client(int port){
        try {
            System.out.println("wait server");
            socket = new Socket("127.0.0.1", port);
            System.out.println("connect");
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
    }



     public int sendMessage(byte[] a){
        while (true) {
            try {
                if (socket.isConnected()) {
                    OutputStream output = socket.getOutputStream();
                    output.write(a);
                    return 1;
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return -1;
            }
        }
    }
}
