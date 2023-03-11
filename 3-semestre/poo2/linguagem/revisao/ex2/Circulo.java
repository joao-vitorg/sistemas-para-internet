package linguagem.revisao.ex2;

public class Circulo {
    private Double raio;

    public Circulo(Double raio) {
        this.raio = raio;
    }

    public Double area() {
        return Math.PI * Math.pow(raio, 2);
    }

    public Double circunferencia() {
        return 2 * Math.PI * raio;
    }

    @Override
    public String toString() {
        return String.format("Area: %.2f Circunferencia: %.2f", area(), circunferencia());
    }
}
