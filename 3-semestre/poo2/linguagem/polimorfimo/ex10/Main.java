package polimorfimo.ex10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Gato());
        animals.add(new Cachorro());
        animals.add(new Vaca());
        animals.add(new Galinha());

        Fazenda.alimentarAnimais(animals);
    }
}
