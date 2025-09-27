import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGrades {

    private ArrayList<String> studentsName = new ArrayList<>();
    private ArrayList<Float> studentsAverageScore = new ArrayList<>();

    public String analyze(String filename){

        File file = new File(filename);
        String returnLine = "";
        try {
            Scanner scannerFile = new Scanner(file);
            while (scannerFile.hasNextLine()){

                float sum = 0;
                String line = scannerFile.nextLine();
                String[] words = line.split("\\s");

                studentsName.add(words[0]);

                for (int i = 1; i < words.length; i++){
                    sum += Integer.parseInt(words[i]);
                }
                studentsAverageScore.add(sum/(words.length-1));
            }
            scannerFile.close();

            for (int i = 0; i < studentsName.size(); i++){
                returnLine += studentsName.get(i) + ": " + studentsAverageScore.get(i) + "\n";
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return returnLine;
    }

    public void bestStudent(){

        float maxScore = Collections.max(studentsAverageScore);
        int indexMax = studentsAverageScore.indexOf(maxScore);

        System.out.println(studentsName.get(indexMax) + ": " + studentsAverageScore.get(indexMax));
    }
    public void worstStudent(){

        float minScore = Collections.min(studentsAverageScore);
        int indexMin = studentsAverageScore.indexOf(minScore);

        System.out.println(studentsName.get(indexMin) + ": " + studentsAverageScore.get(indexMin));
    }
}
