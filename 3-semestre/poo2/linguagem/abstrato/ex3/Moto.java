package abstrato.ex3;

public class Moto extends Veiculo {
    @Override
    public void acelerar(double velocidade) {
        System.out.println("Moto á " + velocidade + "KM/h");
    }
}
