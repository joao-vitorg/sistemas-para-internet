package abstrato.ex10;

public class Galinha extends Animal {
    @Override
    public void comer() {
        System.out.println("A galinha esta comendo...");
    }

    @Override
    public void dormir() {
        System.out.println("Dormindo...");
    }
}
