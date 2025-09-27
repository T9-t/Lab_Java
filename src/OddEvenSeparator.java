import java.util.ArrayList;

public class OddEvenSeparator {

    private ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
    private ArrayList<Integer> oddNumbers = new ArrayList<Integer>();

    public void start(){

        addNumber(2);
        addNumber(3);
        addNumber(4);
        addNumber(9);
        addNumber(13);
        addNumber(6);
        even();
        odd();
    }
    private void addNumber(int number){

        if (number%2 == 0){
            evenNumbers.add(number);
        }
        else{
            oddNumbers.add(number);
        }
    }
    private void even(){
        for(int i = 0; i< evenNumbers.size(); i++){
            System.out.print(evenNumbers.get(i) + " ");
        }
        System.out.println();
    }
    private void odd(){
        for(int i = 0; i< oddNumbers.size(); i++){
            System.out.print(oddNumbers.get(i) + " ");
        }
        System.out.println();
    }
}