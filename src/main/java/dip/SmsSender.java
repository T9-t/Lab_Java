package dip;

public class SmsSender implements Sender{

    @Override
    public void sendMessage(String message) {
        System.out.println("Отправка SMS-сообщения: " + message);
    }
}