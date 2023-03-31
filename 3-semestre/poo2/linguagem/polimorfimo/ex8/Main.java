package polimorfimo.ex8;

public class Main {
    public static void main(String[] args) {
        Computador computador1 = new Notebook();
        Computador computador2 = new Desktop();
        Computador computador3 = new Servidor();

        computador1.iniciar();
        computador2.iniciar();
        computador3.iniciar();
    }
}
