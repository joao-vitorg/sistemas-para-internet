package financial_transaction;

import financial_transaction.models.Card;
import financial_transaction.models.Transaction;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;

public class ServerClient implements Runnable {
    private final HashMap<Long, Card> cards;
    private final Socket socket;

    public ServerClient(Socket socket, HashMap<Long, Card> cards) {
        this.socket = socket;
        this.cards = cards;
    }

    private Transaction receiveTransaction() throws IOException {
        System.out.println("Recebendo dados do cliente...");
        InputStream stream = socket.getInputStream();

        ByteBuffer buffer = ByteBuffer.wrap(stream.readNBytes(26));
        if (Byte.toUnsignedInt(buffer.get()) != 200) {
            throw new IOException("Invalid type");
        }

        long cardNumber = buffer.getLong();
        Transaction transaction = new Transaction(buffer);

        System.out.println(transaction);
        cards.get(cardNumber).addTransaction(transaction);

        return transaction;
    }

    private void sendResponse(Transaction transaction) throws IOException {
        OutputStream stream = socket.getOutputStream();
        byte[] buffer = ByteBuffer.allocate(22)
                .put((byte) 210)                                // 1 byte - type
                .putInt((int) (Math.random() * 100_000))        // 4 bytes - NSU
                .putDouble(transaction.getValue())              // 8 bytes - value
                .putInt(transaction.getTimestamp().getNano())   // 4 bytes - timestamp
                .putInt(transaction.getNetwork())               // 4 bytes - network
                .put((byte) 0)                                  // 1 byte  - response code
                .array();

        System.out.println("Enviando dados para o cliente...");
        System.out.println(Arrays.toString(buffer));
        stream.write(buffer);
    }

    @Override
    public void run() {
        try {
            Transaction transaction = receiveTransaction();
            sendResponse(transaction);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
