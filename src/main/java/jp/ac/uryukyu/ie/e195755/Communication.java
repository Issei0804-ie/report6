package jp.ac.uryukyu.ie.e195755;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Communication {
    public Socket socket = null;
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
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ToString(chars);
    }

    public boolean sendMessage(byte[] a){
        while (true) {
            try {
                if (socket.isConnected()) {
                    OutputStream output = socket.getOutputStream();
                    output.write(a);
                    output.close();
                    return true;
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return false;
            }
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


