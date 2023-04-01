package abstrato.ex12;

public class Moto extends Veiculo {
    public Moto(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public void ligar() {
        System.out.printf("A moto %s está LIGANDO\n", getModelo());
    }

    @Override
    public void desligar() {
        System.out.printf("A moto %s está DESLIGANDO\n", getModelo());
    }
}
