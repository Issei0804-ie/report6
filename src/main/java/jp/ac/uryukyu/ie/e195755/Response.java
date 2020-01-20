package jp.ac.uryukyu.ie.e195755;

class Response {
    Header header = new Header();
    public Response(String code){
    }
    void makeResponseHeader(String statusCode){
        if (statusCode.equals("200")){
            header.header = "HTTP/1.0 " + statusCode + " OK";
        }
    }

    String getResponse(){
        return header.header + "\n\n" + header.body;
    }


    void setBody(String body){ header.body = body; }
}
