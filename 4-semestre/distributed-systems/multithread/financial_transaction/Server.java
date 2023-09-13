package financial_transaction;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3333);

        while (true) {
            Socket connection = server.accept();
            ServerClient serverClient = new ServerClient(connection);
            Thread thread = new Thread(serverClient);
            thread.start();
        }
    }
}
