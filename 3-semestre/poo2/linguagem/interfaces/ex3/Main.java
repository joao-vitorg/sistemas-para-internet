package interfaces.ex3;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<FormaGeometrica> formaGeometricaList = new ArrayList<>();

		formaGeometricaList.add(new Retangulo(3, 4));
		formaGeometricaList.add(new Circulo(5));

		formaGeometricaList.forEach(formaGeometrica -> {
			System.out.printf("Perimetro: %.2f Area: %.2f\n", formaGeometrica.calcularPerimetro(), formaGeometrica.calcularArea());
		});
	}
}
