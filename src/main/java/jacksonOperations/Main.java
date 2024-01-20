package jacksonOperations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jacksonOperations.configurations.ConfigurationReader;
import jacksonOperations.configurations.Environment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        JacksonOperations jacksonOperations = new JacksonOperations();
         ConfigurationReader configurationReader;
        //1. Reading json and deserialize to java object.
        Actor actor = jacksonOperations.readActor();
        System.out.println("Przeczytany aktor: " + actor);

        //2. Write java object as file
        //writer.writeValue
        ObjectMapper writer = new ObjectMapper();
        Actor angelina = new Actor("Angelina", "Jolie", 12, false, 200.00, "Boston");
        writer.writeValue(
                new FileOutputStream("src/main/resources/data/angelina.json"), angelina);

        //3. Write java object as String
        //writer.writeValueAsString()
        ObjectMapper objectMapper = new ObjectMapper();
        Actor brad = new Actor("Brad", "Pitt", 18, true, 300.00, "Chicago");

        String json = objectMapper.writeValueAsString(brad);
        System.out.println("Brad string json: " + json);


        //4. operations on Date type
        //"date":1705756430986 = new Date()
        Movie avatar = new Movie("Avatar", new Date(), 12, true, 450.00);

        ObjectMapper objectMapperMovie = new ObjectMapper();
        String output = objectMapperMovie.writeValueAsString(avatar);

        System.out.println("Movie: " + output);
        //{"title":"Avatar","date":1705756430986,"rating":12,"oscarPrized":true,"budget":450.0}

        //5.  operations on Date type
        // ""date":"2024-01-20" = new Date()
        ObjectMapper objectMapperMovieDate = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapperMovieDate.setDateFormat(dateFormat);
        Movie zielonaMila = new Movie("Zielona mila", new Date(), 12, true, 450.00);
        String output2 = objectMapperMovieDate.writeValueAsString(zielonaMila);
        System.out.println("Zielona mila" + output2);

        //6. Read yaml configuration
        configurationReader = new ConfigurationReader();
        Environment environment = configurationReader.readYamlFile();
        System.out.println(String.format("Active env: %s%s",
                        "name: " + environment.getProperties().get("envName")+ "\n",
                        "appUrl: " + environment.getProperties().get("appUrl")
                        ));

    }
}
