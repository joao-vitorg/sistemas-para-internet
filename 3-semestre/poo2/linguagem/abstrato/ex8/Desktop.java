package abstrato.ex8;

public class Desktop extends Computador {
    @Override
    public void iniciar() {
        System.out.println("Desktop Demorou 20s para iniciar");
    }
}
