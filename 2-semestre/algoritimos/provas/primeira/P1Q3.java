import java.util.Scanner;

public class P1Q3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String txt1 = s.nextLine().toLowerCase();
        String txt2 = s.nextLine().toLowerCase();

        boolean start = txt1.startsWith(txt2);
        boolean end = txt1.endsWith(txt2);

        if (start && end) {
            System.out.println("Ambas");
        } else if (start) {
            System.out.println("Inicio");
        } else if (end) {
            System.out.println("Fim");
        } else {
            System.out.println("Não encontrada");
        }
    }
}
