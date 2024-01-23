package RestSuplier;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestTest extends TestBase {

    private ApiClient api;

    @BeforeEach()
    public void createApiClient() {
        api = createApiClient("/api/student");
    }

    @Test
    public void shouldCreateNewStudent() {

        //send POST method
        api.saveStudent("Angelina").execute();

        //send GET Method
        api.getStudent("Angelina").execute();

        //w asercji
        assertThat(api.getStudent("Angelina").execute().getStatusCode())
                .isEqualTo(200);

    }
}
