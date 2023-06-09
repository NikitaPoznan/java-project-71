package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;

    @BeforeAll
    public static void beforeAll() throws IOException {
        expectedStylish = readFile("src/test/resources/ExpectedStylish.txt");
        expectedPlain = readFile("src/test/resources/ExpectedPlain.txt");
        expectedJson = readFile("src/test/resources/ExpectedJson.json");

    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    void generateDefault() throws Exception {
        String filePath1 = getPath("src/test/resources/file1.json").toString();
        String filePath2 = getPath("src/test/resources/file2.json").toString();
        String result = Differ.generate(filePath1, filePath2);
        assertEquals(result, expectedStylish);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    void generateStylish(String extension) throws Exception {
        String filePath1 = getPath("src/test/resources/file1." + extension).toString();
        String filePath2 = getPath("src/test/resources/file2." + extension).toString();
        String result = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(result, expectedStylish);
    }


    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    void generatePlain() throws Exception {
        String filePath1 = getPath("src/test/resources/file1.json").toString();
        String filePath2 = getPath("src/test/resources/file2.json").toString();
        String result = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(result, expectedPlain);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    void generateJson() throws Exception {
        String filePath1 = getPath("src/test/resources/file1.json").toString();
        String filePath2 = getPath("src/test/resources/file2.json").toString();
        String result = Differ.generate(filePath1, filePath2, "json");
        assertEquals(result, expectedJson);
    }

    public static Path getPath(String fileName) {
        return Paths.get(fileName).toAbsolutePath().normalize();
    }

    public static String readFile(String fileName) throws IOException {
        var testPath = getPath(fileName);
        return Files.readString(testPath).strip();
    }

}
