import dip.EmailSender;
import dip.NotificationService;
import dip.SmsSender;
import isp.OldPrinter;
import isp.Printer;

public class Main {
    public static void main(String[] args) {

        // ---------- I ----------
        Printer printer = new OldPrinter();
        printer.print("Отчёт за неделю");

        // ---------- D ----------
        NotificationService service = new NotificationService(new EmailSender());
        service.send("Ваш заказ готов к выдаче!");

        NotificationService service2 = new NotificationService(new SmsSender());
        service2.send("Ваш заказ готов к выдаче!");
    }
}