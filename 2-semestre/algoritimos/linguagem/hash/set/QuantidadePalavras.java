package set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QuantidadePalavras {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String txt = s.nextLine().toLowerCase();

        Set<String> palavras = new HashSet<>(Arrays.asList(txt.split(" ")));

        System.out.println(palavras.size());
    }
}
