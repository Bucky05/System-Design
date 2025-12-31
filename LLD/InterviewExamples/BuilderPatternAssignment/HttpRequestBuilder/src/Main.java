import java.util.HashMap;
public class Main {
    public static void main(String[] args) throws Exception {
        String method = "GET";
        String url = "https://www.google.com";
        int timeout = 10;
        String body = "";
        HashMap<String,String> map = new HashMap<>();


        HttpRequest httpRequest = new Builder()
                                    .method(method)
                                    .url(url)
                                    .body(body)
                                    .timeout(timeout)
                                    .headers(map)
                                    .build();

        System.out.println(httpRequest.getURL());
    }
}
