package geometry3d;
import exceptions.WrongInputDataError;
import geometry2d.Figure;

public class Cylinder {

    private double height;
    private Figure base;

    public Cylinder(Figure base, double height) throws WrongInputDataError{

        if (height <= 0){
            throw new WrongInputDataError("You input incorrect data");
        }
        else {
            this.base = base;
            this.height = height;
        }
    }
    public double volume(){
        return base.area() * height;
    }
    public String toString() {
        return "Height = " + height + "\n" + base + "\nVolume = " + volume();
    }
}