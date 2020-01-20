package jp.ac.uryukyu.ie.e195755;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;

/**
 * ソケット通信におけるサーバーの役割を提供します。
 * @author 宮良一生
 *
 */
public class Server extends Communication{
    ServerSocket ssocket = null;

    /**
     * 指定されたポートにバインドする。
     * @param port バインドしたいポートを渡します。
     */
    public Server(int port) {
        //指定されたポートにbindを行う。
        try {
            ssocket = new ServerSocket(port);
            System.out.println("*****\nBindOK\n*****\n");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *クライアントの接続を待ちます。
     *
     */
    public void listen() {
        try{
            System.out.println("*****\nWaitClient\n*****\n");
            socket = ssocket.accept();
            writer = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("*****\nConnectClient\n*****\n");

        }catch (java.io.IOException e){
            e.printStackTrace();
            System.out.println("*****\nConnectionError*****\n");
        }
    }
}
