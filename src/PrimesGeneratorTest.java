import java.util.*;

public class PrimesGeneratorTest {
    public void test(int N, int n){

        PrimesGenerator generator = new PrimesGenerator();
        ArrayList<Integer> list = generator.start(n);

        ListIterator<Integer> iterator = list.listIterator();

        for(int i = 1; i != N;i++){

            int number = iterator.next();
            System.out.print(number + " ");
        }
        System.out.print("\n");

        for(int i = 1; i != N;i++){

            int number = iterator.previous();
            System.out.print(number + " ");
        }
        System.out.print("\n");
    }
}
