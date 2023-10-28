package WcTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    int getNumberOfLines(String filePath) throws  FileNotFoundException {
        int numLines = 0;
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            numLines++;
        }
        return numLines;
    }
    int getNumberOfWords(String filePath) throws  FileNotFoundException {
        int numWords = 0;
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            String line =sc.nextLine();
            Scanner wordScanner = new Scanner(line);
            while(wordScanner.hasNext()) {
                numWords++;
            }
        }
        return numWords;
    }
    String readFromFile(String filePath) throws  FileNotFoundException{
        int numWords = 0;
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            stringBuilder.append(sc.nextLine());
            stringBuilder.append("\r\n");

        }
        return stringBuilder.toString();
    }
}
