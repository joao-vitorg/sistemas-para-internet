package financial_transaction;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Client {
    public static void main(String[] args) throws IOException {
        byte[] buffer = ByteBuffer.allocate(26)
                .put((byte) 200)                  // 1 byte - type
                .putDouble(10_000_300.22D)  // 8 bytes - value
                .putInt(1_694_478_869)      // 4 bytes - timestamp
                .putInt(40104)              // 4 bytes - network
                .putLong(4012_3102_1845L)   // 8 bytes - card number
                .put((byte) 0x1)                  // 1 byte  - payment type
                .array();

        ByteBuffer bb = ByteBuffer.wrap(buffer);

        int type = Byte.toUnsignedInt(bb.get());
        double value = bb.getDouble();
        int timestamp = bb.getInt();
        int network = bb.getInt();
        long cardNumber = bb.getLong();
        byte paymentType = bb.get();

        System.out.println("Type: " + type);
        System.out.printf("Value: %.2f\n", value);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Network: " + network);
        System.out.println("Card number: " + cardNumber);
        System.out.println("Payment type: " + paymentType);
        System.out.println();

        for (byte b : buffer) {
            System.out.printf("%02X\n", b);
        }
    }
}