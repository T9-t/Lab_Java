package model;

import java.util.ArrayList;
import java.util.List;

public class ShoeWarehouse {

    public final static List<String> productType = List.of("Sneakers","Boots","Crocs","Sandals");
    private List<Order> orders = new ArrayList<>();
    private final Object lock = new Object();

    public void receiveOrder(Order order) throws InterruptedException {

        synchronized (lock) {
            while (orders.size() >= 5) {
                lock.wait();
            }
            orders.add(order);
            lock.notifyAll();

            System.out.println(this);
        }
    }
    public void fulfillOrder() throws InterruptedException {

        synchronized (lock) {
            while (orders.isEmpty()) {
                lock.wait();
            }
            orders.removeFirst();
            lock.notifyAll();

            System.out.println(this);
        }
    }
    @Override
    public String toString() {
        return orders.toString();
    }
}
