package coding.challenge2.unixWcTool;


import java.io.IOException;

public class WcToolNumberOfCharacters implements  Runnable {
    private String filePath;
    public WcToolNumberOfCharacters(String filePath) {
        this.filePath  = filePath;
    }
    @Override
    public void run() {
        FileReader fileReader = new FileReader();
        try {
            System.out.println(fileReader.getNumberOfCharacters(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
