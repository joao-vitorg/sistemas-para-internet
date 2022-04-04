import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double pesoUsuario, alturaUsuario;

		pesoUsuario = s.nextDouble();
		alturaUsuario = s.nextDouble();

		System.out.println(pesoUsuario / (Math.pow(alturaUsuario, 2)));

		s.close();
	}
}