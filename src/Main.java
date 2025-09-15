import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String name;

        System.out.println("What is your name?");
        System.out.printf("> ");

        name = in.nextLine();

        System.out.println("Hello, " + name +"!");
    }
}