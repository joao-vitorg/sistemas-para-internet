import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TamanhoString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<String> lista = new ArrayList<>();

        int n = s.nextInt();
        int t = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            lista.add(s.nextLine());
        }

        List<String> lista2 = lista.stream().filter(s1 -> s1.length() > t).toList();
        lista.removeAll(lista2);

        System.out.println("Lista 1 : " + lista2.size());
        System.out.println("Lista 2 : " + lista.size());
    }
}
