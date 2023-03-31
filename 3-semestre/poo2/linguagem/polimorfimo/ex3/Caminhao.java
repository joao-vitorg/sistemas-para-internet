package polimorfimo.ex3;

public class Caminhao extends Veiculo {
    @Override
    public void acelerar(double velocidade) {
        System.out.println("Caminhão á " + velocidade + "KM/h");
    }
}
