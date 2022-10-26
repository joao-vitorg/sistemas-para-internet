package tryCatch;

import java.util.Scanner;

public class App {
    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            saque();
        } catch (IllegalArgumentException err){
            System.out.println(err.getMessage());
        }
    }

    private static void saque() throws IllegalArgumentException {
        System.out.print("Valor do saque: ");
        double saque = s.nextDouble();

        if (saque > 400) throw new IllegalArgumentException("SAQUE INVÁLIDO");

        System.out.printf("Saque realizado de %.2f reais.\n", saque);
    }
}
