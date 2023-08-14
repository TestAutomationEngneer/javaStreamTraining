import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import utils.FileContent2Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class TempFile2Test {

    @Test
    void shouldCreateTempFileAndReplace() throws IOException {

        String randomLastname = RandomStringUtils.random(8, true, false).toLowerCase();
        String fileContent = FileContent2Utils.getMyFileContent("actor.csv").replace("${lastname}", randomLastname);


        File file = this.getMyTempFile(".csv");

        Files.write(file.toPath(), fileContent.getBytes());

        this.print(file);

        assertThat(file).hasContent(fileContent);


    }

    private void print(File file) throws IOException {
        System.out.printf("content file %s is %s%s%n", file.getAbsolutePath(),System.lineSeparator(), Files.readString(file.toPath()));
    }

    private File getMyTempFile(String suffix) throws IOException {
        Path tempFile = Files.createTempFile("test -", suffix);
        File file = new File(tempFile.toUri());

        file.deleteOnExit();

        return file;

    }
}
