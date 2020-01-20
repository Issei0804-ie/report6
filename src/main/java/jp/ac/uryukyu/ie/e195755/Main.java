package jp.ac.uryukyu.ie.e195755;

public class Main {
    public static void main(String[] args){
        int port = 8080;
        Server server = new Server(8080);
        /**
         * 設定してからlisten
         */
        server.listen();
        System.out.println(server.read());
        server.sendMessage("HTTP/1.1 200 OK\n\nhello");
        server.close();
    }
}
