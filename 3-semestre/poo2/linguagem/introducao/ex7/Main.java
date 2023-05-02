package introducao.ex7;

public class Main {
    public static void main(String[] args) {
        Calculo calculo = new Calculo(10);

        calculo.credito(40);
        calculo.debito(25);

        System.out.println(calculo.getSaldo());
    }
}
