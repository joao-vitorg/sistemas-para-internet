package interfaces.ex5;

public class Retangulo implements FormaGeometrica, Relacao {
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

	@Override
	public boolean eMaior(FormaGeometrica a) {
		return this.calcularArea() > a.calcularArea();
	}

	@Override
	public boolean eMenor(FormaGeometrica a) {
		return this.calcularArea() < a.calcularArea();
	}

	@Override
	public boolean eIgual(FormaGeometrica a) {
		return this.calcularArea() == a.calcularArea();
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

	@Override
	public String toString() {
		return "Retangulo{" + "base=" + base + ", altura=" + altura + '}';
	}
}
