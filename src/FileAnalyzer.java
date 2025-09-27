import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileAnalyzer {

    private int countLines;
    private int countWords;
    private int countSymbol;

    public String analyze(String filename){

        countLines = 0;
        countWords = 0;
        countSymbol = 0;
        File file = new File(filename);

        try {
            Scanner scannerFile = new Scanner(file);
            while (scannerFile.hasNextLine()){

                countLines++;
                String line = scannerFile.nextLine();

                String[] words = line.split("\\s+");
                countWords += words.length;

                for (String word : words){
                    countSymbol += word.length();
                }
            }
            scannerFile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return "Строк: " + countLines + "\nСлов: " + countWords + "\nСимволов: " + countSymbol;
    }
}