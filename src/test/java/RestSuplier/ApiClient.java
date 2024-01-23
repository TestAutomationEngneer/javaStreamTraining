package RestSuplier;

import RestSuplier.Request.GetStudent;
import RestSuplier.Request.SaveStudent;

import java.util.function.Supplier;

public class ApiClient {

    private final Supplier<RequestSpecBuilder> requestSpecSupplier;

    public ApiClient(Supplier<RequestSpecBuilder> requestSpecSupplier) {
        this.requestSpecSupplier = requestSpecSupplier;
    }

    public SaveStudent saveStudent(String studentName) {
        return new SaveStudent(studentName, requestSpecSupplier.get());
    }

    public GetStudent getStudent(String studentName) {
        return new GetStudent(studentName, requestSpecSupplier.get());
    }
}
