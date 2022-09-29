import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1Q5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] nomes = s.nextLine().toUpperCase().split(" ");
        List<String> conectores = Arrays.stream(new String[]{"E", "DO", "DA", "DOS", "DAS", "DE", "DI", "DU"}).toList();

        for (int i = 0; i < nomes.length; i++) {
            String nome = nomes[i];

            if (conectores.stream().noneMatch(v -> v.equals(nome))) {
                System.out.print((i != 0 ? "." : "") + nome.charAt(0));
            }
        }
    }
}
