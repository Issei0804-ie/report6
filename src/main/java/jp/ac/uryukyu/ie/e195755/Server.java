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
    String httpHeader = null;
    String httpMethod = null;
    String httpRoute = null;

    /**
     * 指定されたポートにバインドする。
     * @param port
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
     * @return 正常終了したならばtrueを返します。
     */
    public boolean listen() {
        try{
            System.out.println("*****\nWaitClient\n*****\n");
            socket = ssocket.accept();
            writer = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("*****\nConnectClient\n*****\n");
            return true;
        }catch (java.io.IOException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String read(){
        httpHeader = super.read();
        //1行目を抜き出す　(.*\n)
        //正規表現で一致させる
        String[] headerLine = httpHeader.split(".*\\r\\n|[\\n\\r\\u2028\\u2029\\u0085]");
        System.out.println("header");
        String[] tmp = headerLine[0].split(" ");//空白で分割
        httpMethod = tmp[0];
        System.out.println("Method "+httpMethod);
        httpRoute = tmp[1];
        System.out.println("route " + httpRoute);
        return "";
    }
}
