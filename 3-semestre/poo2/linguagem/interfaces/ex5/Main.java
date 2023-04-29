package interfaces.ex5;

public class Main {
	public static void main(String[] args) {
		Retangulo f1 = new Retangulo(3, 4);
		Retangulo f2 = new Retangulo(2, 1);

		System.out.println(f1.eMaior(f2) ? f1 : f2);
	}
}
