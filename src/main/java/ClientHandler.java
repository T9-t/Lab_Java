import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{

    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);
    private static final Logger loggerError = LoggerFactory.getLogger("errors");
    private final Socket clientSocket;
    private final Server server;
    private PrintWriter writer;
    private String clientName;

    public ClientHandler(Socket client, Server server) {
        this.server = server;
        clientSocket = client;
    }
    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(clientSocket.getOutputStream(),true);

            writer.println("Enter your name: ");
            clientName = reader.readLine();
            logger.info("Connect client with named: {}", clientName);

            String clientFunc = " ";
            while (!clientFunc.equals("L")) {

                clientFunc = reader.readLine();

                if (clientFunc != null) {
                    if (clientFunc.equals("P")) {

                        String clients = "";
                        for (ClientHandler c : server.getClientList()) {
                            if (!c.clientName.equals(this.clientName)) {

                                clients = clients + c.clientName + "\n";
                            }
                        }
                        clients = clients + "Enter recipient name: ";

                        writer.println(clients);
                        String recipientName = reader.readLine();

                        writer.println("Enter message: ");
                        String message = reader.readLine();

                        server.personalMessage(clientName,recipientName,message);

                    } else if (clientFunc.equals("B")) {
                        writer.println("Enter message: ");
                        String message = reader.readLine();

                        server.broadcastMessage(clientName,message);
                    }
                    else if (!clientFunc.equals("L")){
                        loggerError.warn("Client [{}] enter unknown function: {}",clientName,clientFunc);
                    }
                }
            }
            writer.println("End");
            logger.info("Client [{}] left the server",clientName);
            server.deleteClientHandlers(clientName);

        } catch (IOException e) {
            loggerError.error("ClientHandler run() error: {}", e.getMessage());
        }
    }
    public void sendMessage(String message, String senderName){
        if (message != null){
            writer.println(message);

            logger.info("Client [{}] received a message from {}: {}", clientName, senderName, message);
        }
    }
    public String getClientName(){
        return clientName;
    }
}