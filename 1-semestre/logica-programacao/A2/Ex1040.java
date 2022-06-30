import java.util.Scanner;

public class Ex1040 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		float primeiraNota, segundaNota, terceiraNota, quartaNota, media;

		primeiraNota = s.nextFloat();
		segundaNota = s.nextFloat();
		terceiraNota = s.nextFloat();
		quartaNota = s.nextFloat();

		media = (primeiraNota * 2 + segundaNota * 3 + terceiraNota * 4 + quartaNota * 1) / 10;

		System.out.printf("Media: %.1f\n", media);

		if (media < 5) {
			System.out.println("Aluno reprovado.");
		} else if (media < 7) {
			float notaExame, mediaFinal;

			notaExame = s.nextFloat();

			mediaFinal = (media + notaExame) / 2;

			System.out.println("Aluno em exame.");
			System.out.printf("Nota do exame: %.1f\n", notaExame);
			System.out.println((mediaFinal >= 5) ? "Aluno aprovado." : "Aluno reprovado.");
			System.out.printf("Media final: %.1f\n", mediaFinal);
		} else {
			System.out.println("Aluno aprovado.");
		}

		s.close();
	}
}