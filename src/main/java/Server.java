import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server {

    private static final Logger loggerError = LoggerFactory.getLogger("errors");
    private static final Logger logger = LoggerFactory.getLogger(Server.class);
    private Set<ClientHandler> clientHandlers = new HashSet<>();

    public void startServer() {
        int PORT = 8080;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            logger.info("The server is waiting for clients ___");
            while (true) {
                Socket clientSocket = serverSocket.accept();

                logger.info("The client connected to the server");
                ClientHandler client = new ClientHandler(clientSocket, this);

                clientHandlers.add(client);
                client.start();
            }
        } catch (IOException e) {
            loggerError.error("Server error: {}", e.getMessage()); //
        }
    }
    public Set<ClientHandler> getClientList(){
        return clientHandlers;
    }
    public void broadcastMessage(String clientName, String message){

        for (ClientHandler c : clientHandlers) {
            if (!c.getClientName().equals(clientName)) {

                c.sendMessage("[" + clientName + " -> ALL]: " + message , clientName);
            }
        }
    }
    public void personalMessage(String senderName, String recipientName, String message){

        boolean isUserExisting = false;
        for (ClientHandler c : clientHandlers) {
            if (c.getClientName().equals(recipientName)) {

                c.sendMessage("[" + senderName + " -> " + recipientName + "]: " + message, recipientName);
                isUserExisting = true;
            }
        }
        if (!isUserExisting){
            loggerError.warn("Client [{}] sent to a non-existent client [{}] a message: {}", senderName, senderName, message);
        }
    }
    public void deleteClientHandlers(String clientName){
        clientHandlers.removeIf(c -> c.getClientName().equals(clientName));
    }
}