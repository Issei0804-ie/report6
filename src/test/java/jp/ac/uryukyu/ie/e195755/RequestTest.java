package jp.ac.uryukyu.ie.e195755;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {

    @Test
    void parseHTTPHeader() {
        Request request = new Request();
        String header ="GET / HTTP/1.1\n" +
                "Host: localhost:8080\n" +
                "User-Agent: curl/7.54.0\n" +
                "Accept: */*";
        request.parseHTTPHeader(header);
        assertEquals(request.getMethod(),"GET");
    }
}
