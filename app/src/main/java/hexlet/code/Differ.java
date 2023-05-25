package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Differ {
    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {
        var rawFileContent1 = readFile(firstFilePath);
        var fileContent1 = Parse.parseJson(rawFileContent1);
        var rawFileContent2 = readFile(secondFilePath);
        var fileContent2 = Parse.parseJson(rawFileContent2);
        var differ = Comparator.compare(fileContent1, fileContent2);
        //последним шагом нужно результат компаратора передать в формат. И в самом конце вызывать класс форматтер.
        return null;
    }
// форматор. Создаем пустую строку. Имеется результирующая строка и мы дописываем. Возвращаем Стринг. Принимает результат сравнения.

    public static String readFile (String filePath) throws Exception {
        var path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
                return content;

    }

}
