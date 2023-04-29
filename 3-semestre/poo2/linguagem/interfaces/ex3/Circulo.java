package interfaces.ex3;

public class Circulo implements FormaGeometrica {
	private double raio;

	public Circulo(double raio) {
		this.raio = raio;
	}

	@Override
	public double calcularPerimetro() {
		return 2 * Math.PI * raio;
	}

	@Override
	public double calcularArea() {
		return Math.PI * Math.pow(raio, 2);
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
}
