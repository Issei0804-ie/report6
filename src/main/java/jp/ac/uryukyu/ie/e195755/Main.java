package jp.ac.uryukyu.ie.e195755;

public class Main {
    public static void main(String[] args){
        int port = 8080;
        Server server = new Server(port);
        boolean e = server.listen();
        if (!e)  System.out.println("ConnectionError");
        String a = server.read();
        System.out.println(a);
        //System.out.println("server will send message");
        if (a=="200"){
            server.sendMessage("ok");
        }else{
            server.sendMessage("fin");
        }


        server.close();
    }
}
