import java.util.Scanner;

class ComparaCaracteres {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String out;

        String text = s.nextLine();
        int tamanho = text.length();

        if (tamanho <= 5) out = "invalida";
        else if (text.charAt(0) == text.charAt(tamanho - 1)) out = "iguais";
        else out = "diferentes";

        System.out.println(out);
    }
}
