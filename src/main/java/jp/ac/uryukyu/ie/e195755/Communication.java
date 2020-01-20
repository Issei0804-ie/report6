package jp.ac.uryukyu.ie.e195755;

import java.io.*;
import java.net.Socket;

public class Communication {
    public Socket socket = null;
    public PrintStream writer = null;
    public BufferedReader reader = null;

    /**
     *クライアントから送信されたデータをString型にして戻り値にします。
     * @return クライアントから送られてきたデータ。
     */
    public String read(){
        try {
            String result = reader.readLine();
            while(reader.ready()){
                result += "\n"+reader.readLine();
            }
            return result;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }

    public void sendMessage(String str){
        writer.println(str);
    }

    public void close(){
        try {
            if (socket.isConnected()) {
                writer.close();
                reader.close();
                socket.close();
            } else {
                System.out.println("socket is not connected");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}


