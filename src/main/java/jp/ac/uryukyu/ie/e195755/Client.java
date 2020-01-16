package jp.ac.uryukyu.ie.e195755;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

class Client extends Communication {
    Client(int port){
        try {
            System.out.println("*****\nwait server\n*****\n");
            socket = new Socket("127.0.0.1", port);
            writer = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("*****\nconnect*****\n");
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
    }
}
