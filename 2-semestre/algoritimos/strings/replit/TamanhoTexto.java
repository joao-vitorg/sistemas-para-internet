import java.util.Scanner;

class TamanhoTexto {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String text = s.nextLine();

        System.out.println(text.length() <= 10 ? "pequeno" : "grande");
    }
}