package WcTool;

import java.io.FileNotFoundException;

public class WcToolNumberOfLines implements  Runnable {
    private String filePath;
    public WcToolNumberOfLines(String filePath) {
        this.filePath  = filePath;
    }
    @Override
    public void run() {
        FileReader fileReader = new FileReader();
        try {
            int lines = fileReader.getNumberOfLines(filePath);
            System.out.println(lines);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

