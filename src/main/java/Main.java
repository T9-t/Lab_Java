import lsp.Bird;
import lsp.Penguin;
import lsp.Sparrow;
import ocp.Regular;
import ocp.SuperVip;
import ocp.Vip;
import srp.ReportManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ---------- S ----------
        //ReportManager manager = new ReportManager(List.of(5, 10, 15, 20));
        //manager.generateReport();

        // ---------- O ----------

        Regular regular = new Regular();
        Vip vip = new Vip();
        SuperVip superVip = new SuperVip();

        System.out.println("Regular: " + regular.calculateDiscount(1000));
        System.out.println("VIP: " + vip.calculateDiscount(1000));
        System.out.println("Super VIP: " + superVip.calculateDiscount(1000));

        // ---------- L ----------
        displayBird(new Sparrow());
        displayBird(new Penguin());
    }

    public static void displayBird(Bird bird) {
        bird.eat();
        bird.fly();
    }
}