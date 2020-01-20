package jp.ac.uryukyu.ie.e195755;

/**
 * HTTPレスポンスに関する処理を行うクラスです。
 */
class Response {
    Header header = new Header();

    /**
     *
     * @param code レスポンスヘッダーに埋め込むために、ステータスコードを要求します。
     * @param body　レスポンスのボディを記述します。
     */
    public Response(String code, String body){
        makeResponseHeader(code);
        setBody(body);
    }

    /**
     * レスポンスヘッダーを構成します。
     * @param statusCode 渡されたステータスコードを埋め込みます。(200 or 404)
     */
    void makeResponseHeader(String statusCode){
        if (statusCode.equals("200")){
            header.header = "HTTP/1.0 " + statusCode + " OK";
        } else{
            header.header = "HTTP/1.0 " + statusCode + " 404, NOT FOUND";
        }
    }

    /**
     * makeResponseHeaderメソッドによって作られたレスポンスとBodyを返します。
     * @return クライアントに送信するべきレスポンス
     */
    String getResponse(){
        return header.header + "\n\n" + header.body;
    }


    /**
     * レスポンスのボディをセットします。
     * @param body
     */
    void setBody(String body){ header.body = body; }
}
