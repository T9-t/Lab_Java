import lombok.AllArgsConstructor;
import model.ShoeWarehouse;

@AllArgsConstructor
public class Consumer implements Runnable {

    private ShoeWarehouse warehouse;

    @Override
    public void run() {

        for (int i = 0; i < 5; i++){

            try {
                warehouse.fulfillOrder();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
