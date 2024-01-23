package RestSuplier;

public class TestBase {

    protected ApiClient createApiClient(String baseUri) {
        //pierwsze wstępne ustawienia RequestSpecBuilder, najlepiej ContentType i BaseUrl
        return new ApiClient(() -> new RequestSpecBuilder()
                .setcontentType("Aplication.JSON")
                .setBaseURL(baseUri));
    }
}
