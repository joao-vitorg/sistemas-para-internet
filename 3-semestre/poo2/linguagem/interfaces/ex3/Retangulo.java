package interfaces.ex3;

public class Retangulo implements FormaGeometrica {
	private double base;
	private double altura;

	public Retangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double calcularPerimetro() {
		return 2 * base + 2 * altura;
	}

	@Override
	public double calcularArea() {
		return base * altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
}
