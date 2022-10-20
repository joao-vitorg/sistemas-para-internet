import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LocalizarTexto {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> texts = new HashSet<>();

        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            texts.add(s.nextLine());
        }
        String pesquisa = s.nextLine();

        System.out.println("Textos diferentes : " + texts.size());
        System.out.println("Texto " + (texts.contains(pesquisa) ? "" : "não ") + "localizado");
    }
}
