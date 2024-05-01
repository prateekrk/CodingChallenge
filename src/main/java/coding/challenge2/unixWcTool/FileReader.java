package coding.challenge2.unixWcTool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {
    long getNumberOfLines(String filePath) throws  FileNotFoundException {
        java.io.FileReader file = new java.io.FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(file, 342190);
        return bufferedReader.lines().count();
    }
    int getNumberOfWords(String filePath) throws IOException {
        int numWords = 0;
        java.io.FileReader file = new java.io.FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(file, 342190);
        while(true) {
            String s = bufferedReader.readLine();
            if (s == null) {
                break;
            }
            Matcher matcher = Pattern.compile("[\\w-]+").matcher(s);
            while (matcher.find()) {
                numWords++;
            }

        }
        return numWords;
    }

    long getNumberOfCharacters(String filePath) throws  IOException{
        long numCharacters = 0;
        java.io.FileReader file = new java.io.FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(file, 342190);
       while(true) {
        int c= bufferedReader.read();
       if (c == -1 ) {
        break;
       }
       numCharacters++;}
       return numCharacters;
    }

    long getNumberOfBytes(String filePath) throws  IOException {
        java.io.File file = new java.io.File(filePath);
        return file.length();
    }
}
