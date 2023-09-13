package financial_transaction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ServerClient implements Runnable {
    private final Socket socket;

    public ServerClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream entrada = new DataInputStream(socket.getInputStream());
             DataOutputStream saida = new DataOutputStream(socket.getOutputStream())) {
            System.out.println("Recebendo dados do cliente...");
            int type = Byte.toUnsignedInt(entrada.readByte());
            double value = entrada.readDouble();
            int timestamp = entrada.readInt();
            int network = entrada.readInt();
            byte paymentType = entrada.readByte();
            long cardNumber = entrada.readLong();

            System.out.println("Type: " + type);
            System.out.println("Value: " + value);
            System.out.println("Timestamp: " + timestamp);
            System.out.println("Network: " + network);
            System.out.println("Payment type: " + paymentType);
            System.out.println("Card number: " + cardNumber);
            System.out.println();

            byte[] buffer = ByteBuffer.allocate(22)
                    .put((byte) 210)                          // 1 byte - type
                    .putDouble(value)                         // 8 bytes - value
                    .putInt(timestamp)                        // 4 bytes - timestamp
                    .putInt(network)                          // 4 bytes - network
                    .put((byte) 0)                            // 1 byte  - response code
                    .putInt((int) (Math.random() * 100_000))  // 4 bytes - NSU
                    .array();

            saida.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
