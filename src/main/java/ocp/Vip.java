package ocp;

public class Vip implements DiscountCalculator{

    @Override
    public double calculateDiscount(double price) {
        return price * 0.1;
    }
}
