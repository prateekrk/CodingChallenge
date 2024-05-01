package coding.challenge2.unixWcTool;

public class MainWcTool {
    public static void main( String args[]) {
        args = new String[]{"-c","/Users/kovalliP/Documents/GitHub/CodingChallenge/src/main/resources/Test.txt"};
        String arg = args[0];
            if(args.length > 1) {
                String filePath = args[1];
                switch (arg) {
                    case "-w":
                        new WcToolNumberOfWords(filePath).run();
                        break;
                    case "-c":
                        new WcToolNumberOfBytes(filePath).run();
                        break;
                    case "-l":
                        new WcToolNumberOfLines(filePath).run();
                        break;
                    case "-m":
                        new WcToolNumberOfCharacters(filePath).run();
                        break;
                    default:
                        System.out.println("Invalid args");
                        break;
                }
            } else {
                System.out.println("Processing for whole file");

        }
    }
}
