package tryCach.divisaoPorZero;

public class Main {
    public static void executa() {
        int[] num = {4, 8, 5, 16, 32, 21, 64, 128, 62, 80, 90};
        int[] den = {2, 0, 4, 8, 0, 2, 4};

        for (int i = 0; i < num.length; i++)
            try {
                if (num[i] % 2 != 0) throw new DivisaoNaoExata(num[i], den[i]);
                System.out.println(num[i] + "/" + den[i] + "=" + (num[i] / den[i]));
            } catch (DivisaoNaoExata ex) {
                System.out.println(ex.getMessage());
            }
    }

    public static void main(String[] args) {
        try {
            executa();
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
