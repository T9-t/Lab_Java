
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread serverThread = new Thread(() -> {
            Server chat = new Server();
            chat.startServer();
        });
        serverThread.start();

        Thread.sleep(1000);

        //-------------Class for test, Sonar gives an error
        //Client client1 = new Client("Bob");
        //Client client2 = new Client("Job");
        //Client client3 = new Client("Vob");

        Client client = new Client();
    }
}