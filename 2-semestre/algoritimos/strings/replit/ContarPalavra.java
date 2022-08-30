import java.util.Scanner;

class ContarPalavra {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String texto = s.nextLine();
        String palavra = s.nextLine();
        int count = 0, last = 0, length = palavra.length();

        while (texto.indexOf(palavra, last) != -1) {
            last = texto.indexOf(palavra, last) + length;
            count++;
        }

        System.out.println(count);
    }
} 