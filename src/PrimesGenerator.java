import java.util.ArrayList;
import java.util.Random;

public class PrimesGenerator {

    private final Random randomInt = new Random();

    public ArrayList<Integer> start(int N){

        ArrayList<Integer> simpleNumbers = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            simpleNumbers.add(randomInt.nextInt(100));
        }
        System.out.println(simpleNumbers);

        return simpleNumbers;
    }
}