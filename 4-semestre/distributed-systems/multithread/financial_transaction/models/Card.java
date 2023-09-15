package financial_transaction.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Card {
    private final long number;
    private final String clientName;
    private final Set<Transaction> transactions = new HashSet<>();
    private double balance;

    public Card(long number, String clientName, double balance) {
        this.number = number;
        this.clientName = clientName;
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public long getNumber() {
        return number;
    }

    public String getClientName() {
        return clientName;
    }

    public double getBalance() {
        return balance;
    }

    public Set<Transaction> getTransactions() {
        return Collections.unmodifiableSet(transactions);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", clientName='" + clientName + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
