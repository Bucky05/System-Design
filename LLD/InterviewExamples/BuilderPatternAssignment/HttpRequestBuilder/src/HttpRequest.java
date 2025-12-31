import java.util.HashMap;

import models.Method;

public class HttpRequest {
    
    private Method method;
    private String url;
    private HashMap<String,String> headers = new HashMap<>();
    private String body;
    private int timeout = 10;
    public HttpRequest(Builder builder) {
        method = builder.getMethod();
        url = builder.getURL();
        body = builder.getBody();
        timeout = builder.getTimeout();
        headers = copyHeaders(builder.getHeaders());
    }

     public int getTimeout() {
        return timeout;
    }

    public HashMap<String, String> getHeaders() {
        return copyHeaders(headers);
    }

    public String getBody() {
        return body;
    }

    public String getURL() {
        return url;
    }

    public Method getMethod() {
        return method;
    }


    private HashMap<String,String> copyHeaders(HashMap<String,String> map) {
        HashMap<String,String> headers = new HashMap<>();

        for(String key : map.keySet()) {
            headers.put(key,map.get(key));
        }

        return headers;
    }
}
