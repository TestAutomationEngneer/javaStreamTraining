package RestSuplier.Request;


import RestSuplier.ExecutableRequest;
import RestSuplier.RequestSpecBuilder;
import RestSuplier.Response;

public class SaveStudent implements ExecutableRequest {

    private final RequestSpecBuilder requestSpecBuilder;

    public SaveStudent(String name, RequestSpecBuilder requestSpecBuilder) {
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
//                .spec(requestSpecBuilder.build())
//                .when()
//                .get("/studentDetails/{name}");
        return new Response(requestSpecBuilder);
    }
}
