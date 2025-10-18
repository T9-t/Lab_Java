import lombok.AllArgsConstructor;
import model.Order;
import model.ShoeWarehouse;
import java.security.SecureRandom;
import static model.ShoeWarehouse.productType;

@AllArgsConstructor
public class Producer implements Runnable{

    private ShoeWarehouse warehouse;
    private int numberOrders;

    @Override
    public void run() {

        SecureRandom randomInt = new SecureRandom();
        for (int i = 0; i <  numberOrders; i++){

            int id = randomInt.nextInt(1000)
            ,shoesTypeNumber = randomInt.nextInt(productType.size() - 1)
            ,quantity = randomInt.nextInt(100);

            Order order = new Order(id,productType.get(shoesTypeNumber),quantity);
            try {
                warehouse.receiveOrder(order);
                //System.out.println(warehouse);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}