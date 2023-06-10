package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Differ {

    public static String generate(String firstFilePath, String secondFilePath) throws Exception {
        return generate(firstFilePath, secondFilePath, "stylish");
    }

    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {
        var rawFileContent1 = readFile(firstFilePath);
        var fileExtension1 = getExtension(firstFilePath);
        var fileContent1 = Parser.parse(rawFileContent1, fileExtension1);
        var rawFileContent2 = readFile(secondFilePath);
        var fileExtension2 = getExtension(secondFilePath);
        var fileContent2 = Parser.parse(rawFileContent2, fileExtension2);
        var differ = Comparator.compare(fileContent1, fileContent2);

        return Formatter.format(differ, format);
    }


    public static String readFile(String filePath) throws Exception {
        var path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        return content;

    }

    public static String getExtension(String filePath) {
        var path = filePath.split("\\.");  // экранирование символов
        return path[path.length - 1];
    }
}
