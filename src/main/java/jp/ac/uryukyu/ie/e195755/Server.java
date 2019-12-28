package jp.ac.uryukyu.ie.e195755;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * ソケット通信におけるサーバーの役割を提供します。
 * @author 宮良一生
 *
 */
public class Server {
    ServerSocket ssocket = null;
    Socket socket = null;

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
            System.out.println("ConnectClient");
            return true;
        }catch (java.io.IOException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     *クライアントから送信されたデータをString型にして戻り値にします。
     * @return クライアントから送られてきたデータ。
     */
    public String read(){
        ArrayList<Character> chars = new ArrayList<Character>();
        try{
            InputStream input =  socket.getInputStream();
            int test;
            while(true){
                test = input.read();
                if (test==-1) break;
                char ch = (char) test;
                chars.add(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chars.toString();
    }
}
