import model.ShoeWarehouse;

public class Main {
    public static void main(String[] args) {

        Thread evenThread = new EvenThread();
        Thread oddThread = new Thread(new OddRunnable());

        evenThread.start();
        oddThread.start();

        ShoeWarehouse warehouse = new ShoeWarehouse();
        Thread producer = new Thread(new Producer(warehouse,10));
        Thread consumer = new Thread(new Consumer(warehouse));

        producer.start();
        consumer.start();
    }
}