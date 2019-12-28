package jp.ac.uryukyu.ie.e195755;

import java.net.Socket;

class Client extends Communication {
    Client(int port){
        try {
            System.out.println("wait server");
            socket = new Socket("127.0.0.1", port);
            System.out.println("connect");
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
    }
}
