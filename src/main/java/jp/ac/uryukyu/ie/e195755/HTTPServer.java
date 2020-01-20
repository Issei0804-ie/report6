package jp.ac.uryukyu.ie.e195755;


import java.util.ArrayList;

public class HTTPServer extends Server{
    ArrayList<Route> routes = new ArrayList<Route>();
    ArrayList<Request> requests = new ArrayList<Request>();
    ArrayList<Response> responses = new ArrayList<Response>();

    /**
     * 指定されたポートにバインドする。
     *
     * @param port
     */
    public HTTPServer(int port) {
        super(port);
    }

}
