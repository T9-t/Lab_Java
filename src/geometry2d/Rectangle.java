package geometry2d;

import exceptions.WrongInputDataError;

public class Rectangle implements Figure {

    private double aSide;
    private double bSide;

    public Rectangle(int a, int b) throws WrongInputDataError {

        if (a <= 0 || b <= 0){
            throw new WrongInputDataError("You input incorrect data");
        }
        else {
            aSide = a;
            bSide = b;
        }
    }
    @Override
    public double area() {
        return aSide * bSide;
    }
    @Override
    public double perimeter() {
        return 2 * (aSide + bSide);
    }
    public String toString(){
        return "Side a = " + aSide + " Side b = " + bSide + "\nArea = " + area() + "\nPerimeter = " + perimeter();
    }
}