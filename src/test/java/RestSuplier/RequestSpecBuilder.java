package RestSuplier;


public class RequestSpecBuilder {

    private String header;
    private String param;
    private String baseURL;
    private String contentType;

    public RequestSpecBuilder() {
    }

    public RequestSpecBuilder setcontentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public RequestSpecBuilder setHeader(String header) {
        this.header = header;
        return this;
    }

    public RequestSpecBuilder setParam(String param) {
        this.param = param;
        return this;
    }

    public RequestSpecBuilder setBaseURL(String baseURL) {
        this.baseURL = baseURL;
        return this;
    }
}
