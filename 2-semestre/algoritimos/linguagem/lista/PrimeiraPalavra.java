import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeiraPalavra {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<String> lista = new ArrayList<>();

        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            String primeiraPalavraFrase = s.nextLine().split(" ")[0];
            lista.add(primeiraPalavraFrase.toUpperCase());
        }

        System.out.println("Total de frases : " + (n + 1));
        System.out.println(String.join(" ", lista));
    }
}
