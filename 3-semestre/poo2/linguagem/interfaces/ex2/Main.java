package interfaces.ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Isso é polimorfismo
		List<CartaoWeb> cartaoWebs = new ArrayList<>();

		cartaoWebs.add(new Aniversario("João"));
		cartaoWebs.add(new DiaDosNamorados("Vitor"));
		cartaoWebs.add(new Natal("Gomes"));

		cartaoWebs.forEach(CartaoWeb::showMessage);
	}
}
