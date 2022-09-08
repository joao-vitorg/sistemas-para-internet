import java.util.Scanner;

class SubString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String texto = s.nextLine();
        String palavra = s.nextLine();
        int substr = texto.indexOf(palavra);

        System.out.println(
                (substr == -1)
                        ? texto
                        : texto.substring(substr));
    }
}