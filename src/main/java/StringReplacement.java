import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class StringReplacement {

    public static void main(String[] args) throws IOException {
        String request = getResourceContent("request.json").replace("${filmography}", "Benkarty wojny");
        System.out.println(request);

    }

    public static String getResourceContent(String path) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new FileNotFoundException(String.format("Resource file %s not found", path));
            }

            try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                return bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
    }

}
