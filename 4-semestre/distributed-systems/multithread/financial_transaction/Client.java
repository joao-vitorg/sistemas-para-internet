package financial_transaction;

import financial_transaction.models.Card;
import financial_transaction.models.PaymentType;
import financial_transaction.models.Transaction;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Client {
    private static Socket socket;
    private static Card card;

    public static void main(String[] args) throws IOException {
        socket = new Socket("localhost", 3333);
        card = new Card(4012_3102_1845L, "John Doe");

        Transaction transaction = sendTransaction(100.0, PaymentType.DEBIT);
        receiveResponse();
    }

    private static Transaction sendTransaction(double value, PaymentType paymentType) throws IOException {
        Transaction transaction = card.addTransaction(value, paymentType);
        byte[] buffer = ByteBuffer.allocate(26)
                .put((byte) 200)                  // 1 byte - type
                .put(transaction.toByteArray())   // 17 bytes - transaction
                .putLong(card.getNumber())        // 8 bytes - card number
                .array();

        System.out.println("Enviando dados para o servidor...");
        socket.getOutputStream().write(buffer);
        return transaction;
    }

    private static void receiveResponse() throws IOException {
        System.out.println("Recebendo dados do servidor...");
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        int type = Byte.toUnsignedInt(entrada.readByte());
        double value = entrada.readDouble();
        int timestamp = entrada.readInt();
        int network = entrada.readInt();
        int responseCode = Byte.toUnsignedInt(entrada.readByte());
        int nsu = entrada.readInt();

        System.out.println("Type: " + type);
        System.out.println("Value: " + value);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Network: " + network);
        System.out.println("Response code: " + responseCode);
        System.out.println("NSU: " + nsu);
    }
}
