package abstrato.exercicios.ex12;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(new Carro("Jeep", "Compass", 2018));
        veiculos.add(new Moto("Kawasaki", "NINJA 400 KRT EDITION", 2018));

        Garagem.estacionar(veiculos);
    }
}
