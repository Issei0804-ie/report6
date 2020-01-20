package jp.ac.uryukyu.ie.e195755;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        int port = 8080;

        ArrayList<Route> routes = new ArrayList<Route>();
        routes.add(new Route("/index.html", "index.html"));
        routes.add(new Route("/hogehoge","hoge"));
        HTTPServer server = new HTTPServer(8080, routes);
        server.listen();
        server.close();
    }
}
