package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class FileContent2Utils {
    public static String getMyFileContent(String path) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);

        if (inputStream==null) {
            throw new FileNotFoundException("no file");
        }

        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            return bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
