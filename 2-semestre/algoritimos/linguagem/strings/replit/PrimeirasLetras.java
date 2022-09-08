import java.util.Scanner;

class PrimeirasLetras {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] texto = s.nextLine().split(" ");

        for (String frase : texto) {
            if (frase.length() < 4) continue;
            System.out.println(frase.substring(0, 3));
        }
    }
} 