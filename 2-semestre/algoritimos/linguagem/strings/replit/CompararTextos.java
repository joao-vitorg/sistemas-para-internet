import java.util.Scanner;

class CompararTextos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String t1 = s.nextLine();
        String t2 = s.nextLine();

        System.out.println(t1.equals(t2) ? "correto" : "incorreto");
    }
}
