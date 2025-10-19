package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ShoeWarehouse {

    public final static List<String> productType = List.of("Sneakers","Boots","Crocs","Sandals");
    private List<Order> orders = new ArrayList<>();
    private final Object lock = new Object();
    private ExecutorService service;

    public ShoeWarehouse(ExecutorService service){
        this.service = service;
    }

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
        };
    }
    public void fulfillOrderService() {

        service.submit(() -> {

            synchronized (lock) {
                while (orders.isEmpty()) {
                    try {
                        lock.wait();

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
                orders.removeFirst();
                lock.notifyAll();

                System.out.println(this);
            }
        });
    }
    @Override
    public String toString() {
        return orders.toString();
    }
}