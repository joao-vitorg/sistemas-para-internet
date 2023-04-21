package abstrato.exercicios.ex9;

import java.util.List;

public class CalculadoraDeAreas {
    public static double somarAreas(List<Forma> formas) {
        return formas.stream().mapToDouble(Forma::calcularArea).sum();
    }
}
