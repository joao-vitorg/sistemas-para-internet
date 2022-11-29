package relacionamento.parte1;

public class App {
    public static void main(String[] args) {
        Pessoa albert = new Pessoa("Albert Einstein");
        Pessoa isaac = new Pessoa("Isaac Newton");

        Universidade prinston = new Universidade("Princeton");
        Universidade cambridge = new Universidade("Cambridge");

        albert.setUniversidade(prinston);
        isaac.setUniversidade(cambridge);

        System.out.println(albert);
        System.out.println(isaac);
    }
}
