package financial_transaction;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3333);

        while (true) {
            Socket connection = server.accept();
            SocketThread socketThread = new SocketThread(connection);
            Thread thread = new Thread(socketThread);
            thread.start();
        }
    }
}
