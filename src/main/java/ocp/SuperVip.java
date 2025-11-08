package ocp;

public class SuperVip implements DiscountCalculator{

    @Override
    public double calculateDiscount(double price) {
        return price * 0.2;
    }
}
