import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primeiraNota, segundaNota, terceiraNota;
		double mediaNota;

		primeiraNota = s.nextInt();
		segundaNota = s.nextInt();
		terceiraNota = s.nextInt();

		mediaNota = (primeiraNota + segundaNota + terceiraNota) / 3.0;

		if (mediaNota >= 7)
			System.out.println("O aluno foi Aprovado");
		else if (mediaNota > 5)
			System.out.println("O aluno está de Recuperação");
		else
			System.out.println("O aluno está Reprovado");

		s.close();
	}
}