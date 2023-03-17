package revisao.ex8;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("João", "123", 10);

        contaCorrente.alterarSenha("123", "1234");
        contaCorrente.credito("1234", 40);
        contaCorrente.debito("1234", 25);

        System.out.println(contaCorrente.getSaldo());
    }
}
