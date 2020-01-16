package jp.ac.uryukyu.ie.e195755;

public class Exec {
    public static void main(String[] args){
        int port = 8080;
        Client client = new Client(port);
        String str = "puyopuyo";
        System.out.println("Client send  " + str );
        client.sendMessage(str);
        System.out.println("Server send  " + client.read());
        client.close();
    }
}
