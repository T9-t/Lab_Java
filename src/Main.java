import java.util.*;

public class Main{
    public static void main(String[] args) {

        final int N = 5;
        int pastInt = 0;
        Random randomInt = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> uniqlist = new ArrayList<Integer>();
        ArrayList<Integer> duplicatlist = new ArrayList<Integer>();
        int[] arr;

        System.out.println("//////////////// 1.1,1.2 //////////////////////");
        for (int i = 0; i < N; i++) {
            list.add(randomInt.nextInt(5));
        }
        System.out.println(list);

        System.out.println("////////////////// 1.3 ////////////////////");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("////////////////// 1.4 ////////////////////");
        list.sort(Collections.reverseOrder());
        System.out.println(list);

        System.out.println("////////////////// 1.5 ////////////////////");
        Collections.shuffle(list);
        System.out.println(list);

        System.out.println("////////////////// 1.6 ////////////////////");
        for (int i = 0; i <= list.size(); i++) {

            int nowInt;
            if (i != list.size()) {

                nowInt = list.get(i);
                list.set(i, pastInt);
            }
            else {
                nowInt = list.getLast();
                list.set(0, pastInt);
            }
            pastInt = nowInt;
        }
        System.out.println(list);

        System.out.println("////////////////// 1.7 ////////////////////");
        for (int i : list) {
            if (Collections.frequency(list, i) == 1) {
                uniqlist.add(i);
            }
        }
        System.out.println(uniqlist);

        System.out.println("////////////////// 1.8 ////////////////////");
        for (int i : list) {
            if (Collections.frequency(list, i) != 1) {
                duplicatlist.add(i);
            }
        }
        System.out.println(duplicatlist);

        System.out.println("////////////////// 1.9 ////////////////////");
        arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {

            arr[i] = list.get(i);
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");

        System.out.println("///////////////// 1.10 ////////////////////");
        for (int i : list) {
            System.out.println(i + " = " + Collections.frequency(list, i));
        }

        System.out.println("///////////////// 2 ////////////////////");
        PrimesGeneratorTest test = new PrimesGeneratorTest();

        test.test(4,6);

        //System.out.println("///////////////// 3 ////////////////////");

        System.out.println("///////////////// 4 ////////////////////");



        System.out.println("///////////////// 5 ////////////////////");


        
    }
}