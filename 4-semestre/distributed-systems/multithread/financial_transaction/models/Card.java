package financial_transaction.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Card {
    private final long number;
    private final String clientName;
    private final Set<Transaction> transactions = new HashSet<>();

    public Card(long number, String clientName) {
        this.number = number;
        this.clientName = clientName;
    }

    public Transaction addTransaction(double value, PaymentType paymentType) {
        Transaction transaction = new Transaction(value, paymentType);
        transactions.add(transaction);
        return transaction;
    }

    public long getNumber() {
        return number;
    }

    public String getClientName() {
        return clientName;
    }

    public Set<Transaction> getTransactions() {
        return Collections.unmodifiableSet(transactions);
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", clientName='" + clientName + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
