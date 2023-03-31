package polimorfimo.ex8;

public class Desktop extends Computador {
    @Override
    public void iniciar() {
        super.iniciar();
        System.out.println("Demorou 20s");
    }
}
