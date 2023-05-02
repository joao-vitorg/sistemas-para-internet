package abstrato.ex9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Forma> formas = new ArrayList<>();

        formas.add(new Quadrado(10));
        formas.add(new Circulo(5));
        formas.add(new Circulo(10));
        formas.add(new Triangulo(5, 10));
        formas.add(new Triangulo(10, 20));

        System.out.println(CalculadoraDeAreas.somarAreas(formas));
    }
}
