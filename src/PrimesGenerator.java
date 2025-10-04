import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class PrimesGenerator {

    public ArrayList<Integer> start(int N){

        SecureRandom randomInt = new SecureRandom();
        ArrayList<Integer> simpleNumbers = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            simpleNumbers.add(randomInt.nextInt(100));
        }
        System.out.println(simpleNumbers);

        return simpleNumbers;
    }
}