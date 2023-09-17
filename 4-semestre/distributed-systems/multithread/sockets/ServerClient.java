package sockets;

import sockets.models.card.Card;
import sockets.models.transaction.Transaction;
import sockets.models.transaction.TransactionDto;
import sockets.models.transaction.TransactionResponse;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class ServerClient implements Runnable {
    private final HashMap<Integer, Card> cards;
    private final Socket socket;

    public ServerClient(Socket socket, HashMap<Integer, Card> cards) {
        this.socket = socket;
        this.cards = cards;
    }

    private synchronized Transaction transact(TransactionDto transactionDto) {
        Card card = cards.get(transactionDto.getCardNumber());
        Transaction transaction = transactionDto.getTransaction();

        if (card == null) {
            transaction.setResponseCode(5);
            return transaction;
        }

        card.transact(transaction);
        transaction.setNsu(Server.nsu++);
        return transaction;
    }

    private Transaction receiveTransaction() throws Exception {
        TransactionDto transactionDto = new TransactionDto(socket.getInputStream());
        return transact(transactionDto);
    }

    private void sendResponse(Transaction transaction) throws IOException {
        byte[] buffer = TransactionResponse.build(transaction.getNsu(), transaction.getResponseCode());
        socket.getOutputStream().write(buffer);
    }

    @Override
    public void run() {
        try {
            Transaction transaction = receiveTransaction();
            sendResponse(transaction);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
