package introducao.ex3;

import java.util.Scanner;

public class PalavrasIguais {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String primeiraPalavra = s.next();

        System.out.print("Digite uma palavra: ");
        String segundaPalavra = s.next();

        System.out.println(primeiraPalavra.equals(segundaPalavra) ? "Igual" : "Diferente");
    }
}
