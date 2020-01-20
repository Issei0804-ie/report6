package jp.ac.uryukyu.ie.e195755;

import java.util.ArrayList;

/**
 * 基本的なHTTPサーバーの機能を提供します。
 */
public class HTTPServer extends Server implements HTTPMethod {
    ArrayList<Route> routes =null;
    Request request = new Request();
    Response response = null;

    /**
     * 指定されたポートにバウンドする。
     * @param port バインドしたいポートを渡します。
     * @param routes ルーティング設定を渡します。詳しくはRouteクラスをご覧ください。
     */
    public HTTPServer(int port, ArrayList<Route> routes) {
        super(port);
        this.routes = routes;
    }

    /**
     * クライアントの接続を待ちます。
     *　その後リクエストを処理し、クライアントに適切な結果を返します。
     */
    @Override
    public void listen(){
        super.listen();
        String clientMessage = read();
        request.parseHTTPHeader(clientMessage);
        int statusCode = 0;
        for (Route route: routes){
            statusCode = route.isEqual(request.getClientRoute());
            if (statusCode != 404) break;
        }
        response = new Response(String.valueOf(statusCode), "<h1>hello</h1>");
        sendMessage(response.getResponse());
    }

    /**
     * 未実装
     * ここにGETの場合の処理を書く予定だった。
     */
    @Override
    public void get() {
    }

    /**
     * 未実装
     * ここにPOSTの場合の処理を書く予定だった。
     */
    @Override
    public void post() {
    }
}
