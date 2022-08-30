import java.util.Scanner;

class ValidaCPF {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String cpf = s.nextLine();

        System.out.println(cpf.length() == 11 ? "valido" : "invalido");
    }
}
