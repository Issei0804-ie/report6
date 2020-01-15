package jp.ac.uryukyu.ie.e195755;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;

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

    public boolean close(){
        try {
            if (socket.isConnected()) {
                writer.close();
                reader.close();
                socket.close();
                return true;
            } else {
                return false;
            }
        } catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param list String型にしたい変数を入れる。
     * @return 引数をString型にした変数を返す。
     */
    private String ToString(ArrayList list){
        String result ="";
        for (Object object : list){
            result += object;
        }
        return result;
    }
}


