package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Differ {
    public static String generate(String firstFilePath, String secondFilePath, String format) {
        return null;
    }


    public static String readFile (String filePath) throws Exception {
        var path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
                return null;

    }

}
