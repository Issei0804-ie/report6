package jp.ac.uryukyu.ie.e195755;

public class Main {
    public static void main(String[] args){
        Server server = new Server(8080);
        boolean e = server.listen();
        if (!e)  System.out.println("ConnectionError");
        String a = server.read();
        System.out.println(a);
    }
}
