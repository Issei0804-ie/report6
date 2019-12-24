package jp.ac.uryukyu.ie.e195755;



public class Main {
    public static void main(String[] args){
        Server server = new Server(8080);
        int e = server.listen();
        if (e != 1){
            System.out.println("ConnectionError");
        }
        server.read();
    }
}
