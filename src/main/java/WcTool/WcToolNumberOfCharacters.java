package WcTool;


import java.io.FileNotFoundException;

public class WcToolNumberOfCharacters implements  Runnable {
    private String filePath;
    public WcToolNumberOfCharacters(String filePath) {
        this.filePath  = filePath;
    }
    @Override
    public void run() {
        FileReader fileReader = new FileReader();
        try {
            String txt = fileReader.readFromFile(filePath);
            System.out.println(txt.toCharArray().length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
