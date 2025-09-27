import exceptions.WrongInputDataError;
import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;
import geometry3d.Cylinder;

public class Main{
    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////");
        Button test1 = new Button();
        test1.start();

        System.out.println("////////////////////////////////////////");
        Balance test2 = new Balance();
        test2.start();

        System.out.println("////////////////////////////////////////");
        Bell test3 = new Bell();
        test3.start();

        System.out.println("////////////////////////////////////////");
        OddEvenSeparator test4 = new OddEvenSeparator();
        test4.start();

        System.out.println("////////////////////////////////////////");
        Table test5 = new Table(2,1);
        test5.setValue(0,0,5);
        test5.setValue(1,0,6);
        System.out.println(test5);
        test5.rows();
        test5.average();

        try {
            System.out.println("////////////////////////////////////////");
            Figure cir = new Circle(5);
            System.out.println(cir);

            System.out.println("////////////////////////////////////////");
            Figure rec = new Rectangle(14,5);
            System.out.println(rec);

            System.out.println("////////////////////////////////////////");
            Cylinder cil = new Cylinder(cir,5);
            System.out.println(cil);

        } catch (WrongInputDataError e) {
            throw new RuntimeException(e);
        }
        System.out.println("////////////////////////////////////////");
        FileAnalyzer analyzer = new FileAnalyzer();
        System.out.println(analyzer.analyze("C:\\Users\\Admin\\Desktop\\Java\\src\\txt_test.txt"));

        System.out.println("////////////////////////////////////////");
        StudentGrades grades = new StudentGrades();
        System.out.print(grades.analyze("C:\\Users\\Admin\\Desktop\\Java\\src\\Students.txt"));
        System.out.println(" ");
        grades.bestStudent();
        System.out.println(" ");
        grades.worstStudent();
    }
}