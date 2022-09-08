import java.util.Scanner;

class Calculadora {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] formula = s.nextLine().split(" ");

        if (formula.length != 3) {
            System.out.println("Formula invalida.");
            return;
        }

        double n1 = Double.parseDouble(formula[0]);
        char op = formula[1].charAt(0);
        double n2 = Double.parseDouble(formula[2]);

        double out = switch (op) {
            case '+' -> n1 + n2;
            case '-' -> n1 - n2;
            case '*' -> n1 * n2;
            case '/' -> n1 / n2;
            default -> 0;
        };

        System.out.printf("%.1f\n", out);
    }
}