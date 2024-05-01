package coding.challenge2.unixWcTool;


import java.io.IOException;


public class WcToolNumberOfBytes implements  Runnable {
    private String filePath;
    public WcToolNumberOfBytes(String filePath) {
        this.filePath  = filePath;
    }
    @Override
    public void run() {
        FileReader fileReader = new FileReader();
        try {
            System.out.println(fileReader.getNumberOfBytes(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
