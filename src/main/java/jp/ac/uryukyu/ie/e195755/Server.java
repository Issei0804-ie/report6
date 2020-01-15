package jp.ac.uryukyu.ie.e195755;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
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
     * @param port
     */
    public Server(int port) {
        //指定されたポートにbindを行う。
        try {
            ssocket = new ServerSocket(port);
            System.out.println("BindOk");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *クライアントの接続を待ちます。
     * @return 正常終了したならばtrueを返します。
     */
    public boolean listen() {
        try{
            System.out.println("WaitClient");
            socket = ssocket.accept();
            writer = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("ConnectClient");
            return true;
        }catch (java.io.IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
