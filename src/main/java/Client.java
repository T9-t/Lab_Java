import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private final int PORT = 8080;
    private final String HOST = "localhost";

    //-------------Class for test Sonar, gives an error
    //public Client(String name){
    //    try {
    //        Socket socket = new Socket(HOST, PORT);
    //        PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
    //        writer.println(name);

    //    } catch (IOException ex) {
    //      throw new RuntimeException(ex);
    //    }
    //}
    public Client() {
        try (Socket socket = new Socket(HOST, PORT)) {

            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            System.out.print(reader.readLine());
            String clientName = console.readLine();
            writer.println(clientName);
            System.out.println("Connect to the Server");

            Thread serverReader = new Thread(() -> {

                String serverMessage = " ";
                while (!serverMessage.equals("End")){
                    try {
                        serverMessage = reader.readLine();
                        if (serverMessage != null && !serverMessage.equals("End")) {

                            System.out.println(serverMessage);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            serverReader.start();

            String func = "";
            while (!func.equals("L")) {

                System.out.print("Enter function (P - personal message, B - broadcast message, L - logout): ");
                func = console.readLine();
                writer.println(func);

                if (func.equals("P")) {

                    String recipientName = console.readLine();
                    writer.println(recipientName);

                    String message = console.readLine();
                    writer.println(message);

                } else if (func.equals("B")) {

                    String message = console.readLine();
                    writer.println(message);
                }
            }
            System.out.println("You have left the server");

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}