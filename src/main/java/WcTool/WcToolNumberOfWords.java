package WcTool;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class WcToolNumberOfWords implements  Runnable {
    private String filePath;
    public WcToolNumberOfWords(String filePath) {
        this.filePath  = filePath;
    }
    @Override
    public void run() {
        FileReader fileReader = new FileReader();
        try {
            int count = fileReader.getNumberOfWords(filePath);
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
