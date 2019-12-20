package test.print;

public class TestResponse {

    private final String method;
    private final String url;

    public TestResponse(String method, String url) {
        this.method = method;
        this.url = url;
    }

    public String url() {
        return url;
    }

    public String method() {
        return method;
    }
}
