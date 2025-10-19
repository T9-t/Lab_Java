import lombok.AllArgsConstructor;
import model.ShoeWarehouse;

@AllArgsConstructor
public class Producer implements Runnable{

    private ShoeWarehouse warehouse;
    private int numberOrders;

    @Override
    public void run() {
        for (int i = 0; i <  numberOrders; i++){
            try {
                warehouse.receiveOrder(Main.randomOrder());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}