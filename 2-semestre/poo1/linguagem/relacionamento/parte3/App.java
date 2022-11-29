package relacionamento.parte3;

public class App {
    public static void main(String[] args) {
        Pessoa albert = new Pessoa("Albert Einstein");
        Pessoa isaac = new Pessoa("Isaac Newton");

        Departamento fisica = new Departamento("Fisca");
        Departamento matemtca = new Departamento("Matematica");

        Universidade prinston = new Universidade("Princeton", fisica);
        Universidade cambridge = new Universidade("Cambridge", matemtca);

        albert.setUniversidade(prinston);
        isaac.setUniversidade(cambridge);

        System.out.println(albert);
        System.out.println(isaac);
    }
}
