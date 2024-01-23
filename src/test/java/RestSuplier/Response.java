package RestSuplier;

public class Response {

    private RequestSpecBuilder requestSpecBuilder;

    private static String content = """
            {
            "status": "success"
            }
            """;

    public Response(RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
    }

    public static String getContent() {
        return content;
    }

    public int getStatusCode() {
        return 200;
    }
}
