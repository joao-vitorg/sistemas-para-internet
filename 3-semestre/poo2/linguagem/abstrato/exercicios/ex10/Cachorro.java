package abstrato.exercicios.ex10;

public class Cachorro extends Mamifero {
    @Override
    public void comer() {
        System.out.println("O Cachorro esta comendo...");
    }

    @Override
    public void dormir() {
        System.out.println("Dormindo...");
    }

    @Override
    public void amamentar() {
        System.out.println("Amamentando...");
    }
}
