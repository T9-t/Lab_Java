package dip;

public class NotificationService {

    private final Sender sender;
    public NotificationService(Sender sender){
        this.sender = sender;
    }
    public void send(String message) {
        sender.sendMessage(message);
    }
}