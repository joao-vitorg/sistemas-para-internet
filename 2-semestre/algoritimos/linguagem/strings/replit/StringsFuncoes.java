import java.util.Scanner;

class StringsFuncoes {
    public static void calculaCusto(String cidade, double custo) {
        if (cidade.equals("Brasilia")) custo *= 2;
        else if (!cidade.equals("Uberlandia")) custo /= 2;

        System.out.printf("O custo de vida em %s e R$ %.2f\n", cidade, custo);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double custo = s.nextDouble();
        s.nextLine();
        String cidade = s.nextLine();

        calculaCusto(cidade, custo);
    }
}
