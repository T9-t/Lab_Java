package dip;

public class EmailSender implements Sender {

    @Override
    public void sendMessage(String message) {
        System.out.println("Отправка письма: " + message);
    }
}
