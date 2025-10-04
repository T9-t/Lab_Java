import java.util.*;

public class Main{
    public static void main(String[] args) {

        final int N = 5;
        int pastInt = 0;
        Random randomInt = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> uniqlist = new ArrayList<>();
        ArrayList<Integer> duplicatlist = new ArrayList<>();
        int[] arr;

        System.out.println("//////////////// 1.1,1.2 //////////////////////");
        for (int i = 0; i < N; i++) {
            list.add(randomInt.nextInt(100));
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
        PrimesGeneratorTest test2 = new PrimesGeneratorTest();

        test2.test(4,6);

        System.out.println("///////////////// 3 ////////////////////");

        ArrayList<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Anna","Johnson",15));
        humanList.add(new Human("Drew","Johnson",23));
        humanList.add(new Human("Hailey","Hernandez",13));
        humanList.add(new Human("Linda","Roberts",30));
        humanList.add(new Human("Jenny","Thomas",45));

        HashSet<Human> hashSetHumans = new HashSet<>(humanList); //In random order
        System.out.println(hashSetHumans);

        LinkedHashSet<Human> linkedHashSetHumans = new LinkedHashSet<>(humanList); //In the order of the original array
        System.out.println(linkedHashSetHumans);

        TreeSet<Human> treeSetHumans = new TreeSet<>(humanList); //Sorts by compareTo in Human(Name)
        System.out.println(treeSetHumans);

        TreeSet<Human> treeSetHumansLastName = new TreeSet<>(new HumanComparatorByLastName()); //Sorts by compareTo in HumanComparatorByLastName(LastName)
        treeSetHumansLastName.addAll(humanList);
        System.out.println(treeSetHumansLastName);

        TreeSet<Human> treeSetHumansage = new TreeSet<>(new Comparator<>() {  //Sorts by age
            @Override
            public int compare(Human o1, Human o2) {
                return Integer.compare(o1.age,o2.age);
            }
        });
        treeSetHumansage.addAll(humanList);
        System.out.println(treeSetHumansage);

        System.out.println("///////////////// 4 ////////////////////");

        String text = "Words words name counts name name coUnts avey";
        String[] words = text.split("\\s+");
        HashMap<String,Integer> map = new HashMap<>();

        for (String s : words) {

            String word = s.toLowerCase();
            if (map.get(word) != null) {

                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        System.out.println(map);

        System.out.println("///////////////// 5 ////////////////////");

        Map<String,Integer> studentsScore = new HashMap<>();
        Map<Integer,String> scoreStudents = new HashMap<>();
        studentsScore.put("Drew",5);
        studentsScore.put("Alan",4);
        studentsScore.put("Janet",5);
        studentsScore.put("Bryan",3);
        studentsScore.put("Anna",4);

        for (Map.Entry<String,Integer> entry : studentsScore.entrySet()){

            String names;
            if (scoreStudents.get(entry.getValue()) != null){

                names = scoreStudents.get(entry.getValue()) + "; " + entry.getKey();
            }
            else{
                names = entry.getKey();
            }
            scoreStudents.put(entry.getValue(), names);
        }
        System.out.println(studentsScore);
        System.out.println(scoreStudents);
    }
}