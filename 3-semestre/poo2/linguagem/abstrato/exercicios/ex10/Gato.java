package abstrato.exercicios.ex10;

public class Gato extends Mamifero {
    @Override
    public void comer() {
        System.out.println("O Gato esta comendo...");
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
