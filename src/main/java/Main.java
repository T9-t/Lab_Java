import model.Order;
import model.ShoeWarehouse;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static model.ShoeWarehouse.productType;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        final int N = 10;
        ExecutorService service = Executors.newFixedThreadPool(2);

        Thread evenThread = new EvenThread();
        Thread oddThread = new Thread(new OddRunnable());

        evenThread.start();
        oddThread.start();

        ShoeWarehouse warehouse = new ShoeWarehouse(service);
        Thread producer = new Thread(new Producer(warehouse,N));
        Thread consumer = new Thread(new Consumer(warehouse));

        producer.start();
        consumer.start();

        for (int i = 0; i < N; i++) {
            service.submit(() -> {
                try {
                   warehouse.receiveOrder(randomOrder());

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            });
            warehouse.fulfillOrderService();
        }
        service.shutdown();
    }
    public static Order randomOrder(){

        SecureRandom randomInt = new SecureRandom();
        int id = randomInt.nextInt(1000)
        ,shoesTypeNumber = randomInt.nextInt(productType.size() - 1)
        ,quantity = randomInt.nextInt(100);

        return new Order( id,productType.get(shoesTypeNumber),quantity);
    }
}