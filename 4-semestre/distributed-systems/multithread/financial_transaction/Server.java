package financial_transaction;

import financial_transaction.models.Card;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    private static final HashMap<Long, Card> cards = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3333);

        // Creating cards
        cards.put(401231021845L, new Card(401231021845L, "João", 1000.0));
        cards.put(893739273038L, new Card(893739273038L, "Maria", 500));
        cards.put(123456789012L, new Card(123456789012L, "José", 2000));

        while (true) {
            Socket connection = server.accept();
            ServerClient serverClient = new ServerClient(connection, cards);
            Thread thread = new Thread(serverClient);
            thread.start();
        }
    }
}
