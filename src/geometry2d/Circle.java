package geometry2d;
import exceptions.WrongInputDataError;

public class Circle implements Figure {

    private int radius;
    private final float PI = 3.14f;

    public Circle(int radius) throws WrongInputDataError{

        if (radius <= 0){
            throw new WrongInputDataError("You input incorrect data");
        }
        else {
            this.radius = radius;
        }
    }
    @Override
    public double area() {
        return PI * radius * radius;
    }
    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }
    public String toString(){
        return "Radius = " + radius + "\nArea = " + area() + "\nPerimeter = " + perimeter();
    }
}