package abstrato.ex12;

public class Carro extends Veiculo {
    public Carro(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public void ligar() {
        System.out.printf("O carro %s está LIGANDO\n", getModelo());
    }

    @Override
    public void desligar() {
        System.out.printf("O carro %s está DESLIGANDO\n", getModelo());
    }
}
