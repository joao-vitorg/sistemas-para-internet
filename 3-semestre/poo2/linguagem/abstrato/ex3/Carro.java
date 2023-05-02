package abstrato.ex3;

public class Carro extends Veiculo {
    @Override
    public void acelerar(double velocidade) {
        System.out.println("Carro á " + velocidade + "KM/h");
    }
}
