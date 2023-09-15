package financial_transaction.models;

import java.nio.ByteBuffer;
import java.time.Instant;

public class Transaction {
    private final double value;
    private final Instant timestamp;
    private final int network;
    private final PaymentType paymentType;
    private int nsu;
    private int responseCode;

    public Transaction(double value, PaymentType paymentType) {
        this.value = value;
        this.paymentType = paymentType;
        timestamp = Instant.now();
        network = (int) (Math.random() * 100_000);
    }

    public Transaction(ByteBuffer buffer) {
        this.value = buffer.getDouble();
        this.timestamp = Instant.ofEpochSecond(buffer.getInt());
        this.network = buffer.getInt();
        this.paymentType = PaymentType.values()[buffer.get()];
    }

    public byte[] toByteArray() {
        return ByteBuffer.allocate(17)
                .putDouble(value)                           // 8 bytes - value
                .putInt((int) timestamp.getEpochSecond())   // 4 bytes - timestamp
                .putInt(network)                            // 4 bytes - network
                .put((byte) paymentType.ordinal())          // 1 byte  - payment type
                .array();
    }

    public int getNsu() {
        return nsu;
    }

    public void setNsu(int nsu) {
        this.nsu = nsu;
    }

    public double getValue() {
        return value;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getNetwork() {
        return network;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "value=" + value +
                ", timestamp=" + timestamp +
                ", network=" + network +
                ", paymentType=" + paymentType +
                ", nsu=" + nsu +
                ", responseCode=" + responseCode +
                '}';
    }
}
