package financial_transaction;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketThread implements Runnable {
    private final Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream entrada = new DataInputStream(socket.getInputStream())) {
            String mensagem = entrada.readUTF();
            System.out.println(mensagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
