package jp.ac.uryukyu.ie.e195755;

/**
 * HTTPServerのルーティング機能を提供するメソッドです。
 * これらはインスタンスを生成した上で、HTTPServerの引数として渡す必要があります。
 */
class Route {
    String route = null;
    String filePath = null;

    /**
     *
     * @param route クライアントにアクセスしてほしいパスを記述します。
     * @param filePath アクセスされた時に返すファイルパスを記述します //未実装
     */
    Route(String route, String filePath) {
        this.route = route;
        this.filePath = filePath;
    }

    /**
     *
     * @param clientRoute クライアントがアクセスしたルートが渡されます。
     * @return ステータスコードを返します(200 or 404)
     */
    int isEqual(String clientRoute){
        if (route.equals(clientRoute)){
            return 200;
        }else {
            return 404;
        }
    }
}
