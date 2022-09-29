import java.util.Scanner;

class P1Q1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String nome = s.next();

        if (nome.length() < 4) {
            System.out.println("Nome inválido");
        } else {
            System.out.println(nome.substring(0, 4));
        }
    }
}