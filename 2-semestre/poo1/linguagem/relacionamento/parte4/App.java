package relacionamento.parte4;

public class App {
    public static void main(String[] args) {
        Pessoa albert = new Pessoa("Albert Einstein");
        Pessoa isaac = new Pessoa("Isaac Newton");

        Departamento fisica = new Departamento("Fisca");
        Departamento matematica = new Departamento("Matematica");
        Departamento artes = new Departamento("Artes");
        Departamento programacao = new Departamento("Programação");

        Universidade prinston = new Universidade("Princeton");
        Universidade cambridge = new Universidade("Cambridge");

        prinston.setDepartamento(fisica);
        prinston.setDepartamento(artes);

        cambridge.setDepartamento(matematica);
        cambridge.setDepartamento(programacao);

        albert.setUniversidade(prinston);
        albert.setDepartamento(fisica);

        isaac.setUniversidade(cambridge);
        isaac.setDepartamento(matematica);

        System.out.println(albert);
        System.out.println(isaac);
    }
}
