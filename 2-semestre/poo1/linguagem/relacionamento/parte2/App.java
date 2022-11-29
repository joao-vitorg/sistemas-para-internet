package relacionamento.parte2;

public class App {
    public static void main(String[] args) {
        Pessoa albert = new Pessoa("Albert Einstein");
        Pessoa isaac = new Pessoa("Isaac Newton");

        Universidade prinston = new Universidade("Princeton", "Fisca");
        Universidade cambridge = new Universidade("Cambridge", "Matematica");

        albert.setUniversidade(prinston);
        albert.setDepartamento(prinston.getDepartamento());

        isaac.setUniversidade(cambridge);
        isaac.setDepartamento(cambridge.getDepartamento());

        System.out.println(albert);
        System.out.println(isaac);
    }
}
