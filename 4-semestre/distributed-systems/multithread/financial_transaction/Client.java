package financial_transaction;

import financial_transaction.models.PaymentType;
import financial_transaction.models.Transaction;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Client {
    private static Socket socket;
    private static Long cardNumber;

    public static void main(String[] args) throws IOException {
        socket = new Socket("localhost", 3333);
        cardNumber = 4012_3102_1845L;

        sendTransaction(100.0, PaymentType.DEBIT);
        receiveResponse();
    }

    private static void sendTransaction(double value, PaymentType paymentType) throws IOException {
        Transaction transaction = new Transaction(value, paymentType);
        byte[] buffer = ByteBuffer.allocate(26)
                .put((byte) 200)                  // 1 byte - type
                .putLong(cardNumber)              // 8 bytes - card number
                .put(transaction.toByteArray())   // 17 bytes - transaction
                .array();

        System.out.println("Enviando dados para o servidor...");
        socket.getOutputStream().write(buffer);
        socket.getOutputStream().flush();
    }

    private static void receiveResponse() throws IOException {
        System.out.println("Recebendo dados do servidor...");
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        int type = Byte.toUnsignedInt(entrada.readByte());
        int nsu = entrada.readInt();
        double value = entrada.readDouble();
        int timestamp = entrada.readInt();
        int network = entrada.readInt();
        int responseCode = Byte.toUnsignedInt(entrada.readByte());

        System.out.println("Type: " + type);
        System.out.println("NSU: " + nsu);
        System.out.println("Value: " + value);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Network: " + network);
        System.out.println("Response code: " + responseCode);
    }
}
