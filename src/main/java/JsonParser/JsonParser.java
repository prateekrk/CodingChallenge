package JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class JsonParser {
    public int isValidJson(String filePath) {
        String json = readFromFile(filePath);
        return  validateJson(json);
    }

    public int validateJson(String data) {
        if(data.isEmpty()) {
            return 1;
        }
        if(validateOpeningAndClosingBracket(data)) {
            return 0;
        }
        return 1;
    }

    private boolean validateOpeningAndClosingBracket(String module) {
        return module.charAt(0) == '{' && module.charAt(module.length() - 1) == '}';
    }

    private String readFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            while(scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            return stringBuilder.toString();
        } catch (FileNotFoundException exception) {
            System.out.println(Arrays.toString(exception.getStackTrace()));
            return "";
        }
    }
}
