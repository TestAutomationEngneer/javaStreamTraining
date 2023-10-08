import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.FileContentUtils.getFileContent;


public class TempFilesTest {

    @Test
    public void checkTempFileContent() throws IOException {
        //wyzwanie:  lastname to pole walidowane i zadsada w API jest taka, że
        //wartości pola musi być unikatowe. Przy pierwszej egzekucji testu będzie ok, ale drugi test będzie
        //failed z wiadomością: Actor already exists.
        //Musze zadać o unikatowość nazwisk i randomizować te nazwiska

        String randomLastname = RandomStringUtils.random(8, true, false);

        String fileContent = getFileContent("actor.csv").replace("${lastname}", randomLastname);

        File file = this.createFile(".csv");

        Files.write(file.toPath(), fileContent.getBytes());

        this.print(file);

        assertThat(file).hasContent(fileContent);

    }

    private File createFile(String suffix) throws IOException
    {
        Path path = Files.createTempFile("test-", suffix);
        File file = new File(path.toUri());
        file.deleteOnExit();

        return file;
    }

    private void print(File file) throws IOException
    {
        System.out.printf("Content of %s is %s%s%n", file.getAbsolutePath(), System.lineSeparator(), Files.readString(file.toPath()));
    }
}
