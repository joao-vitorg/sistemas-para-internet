package solid.introducao.banco;

public class Main {
    public static void main(String[] args) {
        ContaBancaria contaBancaria = new ContaBancaria(11);

        contaBancaria.depositar(11);
        System.out.println(contaBancaria);

        contaBancaria.sacar(5);
        System.out.println(contaBancaria);

        System.out.println(contaBancaria.getHistorico());
    }
}
