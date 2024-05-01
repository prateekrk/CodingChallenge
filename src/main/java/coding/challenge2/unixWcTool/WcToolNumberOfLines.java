package coding.challenge2.unixWcTool;

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
            long lines = fileReader.getNumberOfLines(filePath);
            System.out.println(lines);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

