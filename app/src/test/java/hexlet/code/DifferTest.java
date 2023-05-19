package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class DifferTest {
    private static final String EXPECTED_STYLISH = """
{
  - follow: false
    host: hexlet.io
  - proxy: 123.234.53.22
  - timeout: 50
  + timeout: 20
  + verbose: true
}
            """;
    @Test
    void generate() throws Exception {
        String filePath1 = getPath("resources/file1.json").toString();
        String filePath2 =getPath("resources/file2.json").toString();
    Differ.generate(filePath1, filePath2, "stylish"); // требуется сохранить результат в переменную(из generate)
        // нужно взять ожидаемый результат, что было в примере, нужно создать, провести сравнение при помощи assertion
    }


    public static Path getPath(String fileName){
        return Paths.get(fileName).toAbsolutePath().normalize();
    }

}