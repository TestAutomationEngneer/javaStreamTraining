package RestSuplier.Request;


import RestSuplier.ExecutableRequest;
import RestSuplier.RequestSpecBuilder;
import RestSuplier.Response;

public class GetStudent implements ExecutableRequest {
    private final RequestSpecBuilder requestSpecBuilder;

    public GetStudent(String name, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        //uzupełnienie RequestSpecBuilder, dodanie szczegółów jak header czy parametry
        // this.requestSpecBuilder.addPathParam("name", name);
        this.requestSpecBuilder.setHeader("header")
                .setParam("name = " + name);
    }

    @Override
    public Response execute() {
        //wywołanie restAssured i zwracanie obiektu Response.
//        return given()
//                .spec(requestSpecBuilder.build()) <-  tu jest dopiero finalne zbudowanie obiektu RequestSpecBuilder.
//                .when()
//                .get("/studentDetails/{name}");
        return new Response(requestSpecBuilder);
    }


}
