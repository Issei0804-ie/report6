package jp.ac.uryukyu.ie.e195755;

import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    Socket socket = new Socket();
    InetSocketAddress address = new InetSocketAddress("localhost",8080);
    public Client(){
        try{
            socket.connect(address);
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
    }
}
