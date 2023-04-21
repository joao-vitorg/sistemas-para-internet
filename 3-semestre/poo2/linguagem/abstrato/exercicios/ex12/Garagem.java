package abstrato.exercicios.ex12;

import java.util.List;

public class Garagem {
    public static void estacionar(List<Veiculo> veiculos) {
        veiculos.forEach(Veiculo::ligar);
        veiculos.forEach(Veiculo::desligar);
    }
}
