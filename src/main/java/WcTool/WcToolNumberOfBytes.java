package WcTool;


import java.io.FileNotFoundException;


public class WcToolNumberOfBytes implements  Runnable {
    private String filePath;
    public WcToolNumberOfBytes(String filePath) {
        this.filePath  = filePath;
    }
    @Override
    public void run() {
        FileReader fileReader = new FileReader();
        try {
            String txt = fileReader.readFromFile(filePath);
            System.out.println(txt.toCharArray().length * 2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
