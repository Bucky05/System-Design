import models.Method;
import java.util.HashMap;
public class Builder {
    private Method method;
    private String url;
    private HashMap<String,String> headers = new HashMap<>();
    private String body;
    private int timeout = 10;

    public Builder method(String method) {
        try {
            this.method = Method.valueOf(method);
            return this;
        } catch (Exception e) {
            throw new IllegalArgumentException(method +" is not a valid Method name");
        }
    }

    public Builder url(String url) {
        String prefix = url.substring(0,8);
        
        if(!prefix.equals("https://") && !url.substring(0,7).equals("http://")) {
            throw new IllegalArgumentException("Not a valid URL");
        }
        this.url = url;
        return this;

    }

    public Builder headers(HashMap<String,String> headers) {
        this.headers = headers;
        return this;
    }

    public Builder timeout(int timeout) {
        if(timeout < 0) {
            throw new IllegalArgumentException();
        }
        this.timeout = timeout;
        return this;
    }

    public Builder body(String body) {
        this.body = body;
        return this;
    }

    public int getTimeout() {
        return timeout;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
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


    public HttpRequest build() {
        if(method == null) {
            throw new IllegalStateException("method is a required field");
        }
        if(url == null) {
            throw new IllegalStateException("url is a required field");
        }
        if(method == Method.GET && body != null && body.length() != 0) {
            throw new IllegalStateException("GET requests must not include a body");
        } 
        return new HttpRequest(this);
    }
} 
