package jp.ac.uryukyu.ie.e195755;

/**
 * 送られてきたリクエストを処理します。
 */
class Request {
    String clientRoute = null;
    String method = null;
    Header header = new Header();

    /**
     * 送られてきたヘッダーからメソッドとルートをパースします。
     * @param header クライアントから送られてきたヘッダー
     */
    void parseHTTPHeader(String header){
        this.header.header = header;
        //1行目を抜き出す　(.*\n)
        //正規表現で一致させる
        try{
            String[] headerLine = header.split(".*\\r\\n|[\\n\\r\\u2028\\u2029\\u0085]");//改行コードで分割
            String[] tmp = headerLine[0].split(" ");//空白で分割
            method = tmp[0];
            clientRoute = tmp[1];
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    /**
     * クライアントが要求したルートを返します。
     * @return
     */
    String getClientRoute(){ return clientRoute; }

    /**
     * クライアントが要求したメソッドを返します。
     * @return
     */
    String getMethod(){ return method; }
}
