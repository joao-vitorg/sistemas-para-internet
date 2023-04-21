package abstrato.exercicios.ex10;

import java.util.List;

public class Fazenda {
    public static void alimentarAnimais(List<Animal> animals) {
        animals.forEach(Animal::comer);
    }
}
