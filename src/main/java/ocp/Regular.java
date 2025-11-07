package ocp;

public class Regular implements DiscountCalculator{

    @Override
    public double calculateDiscount(double price) {
        return price * 0.05;
    }
}
