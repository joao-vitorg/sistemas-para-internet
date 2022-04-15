import java.util.Scanner;

public class ERE07 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int idade, menorIdade, maiorIdade, acimaTresMil, pessoas;
		double salario, somaSalario;
		char sexo, continuar;

		menorIdade = Integer.MAX_VALUE;
		maiorIdade = Integer.MIN_VALUE;
		acimaTresMil = 0;
		somaSalario = 0;
		pessoas = 0;

		do {
			idade = s.nextInt();
			sexo = s.next().charAt(0);
			salario = s.nextDouble();
			continuar = s.next().charAt(0);

			acimaTresMil += (sexo == 'f' && salario >= 3000) ? 1 : 0;
			menorIdade = Math.min(menorIdade, idade);
			maiorIdade = Math.max(maiorIdade, idade);
			somaSalario += salario;
			pessoas++;
		} while (continuar == 's');

		System.out.printf("Media salarios = R$ %.2f\n", somaSalario / pessoas);
		System.out.printf("Menor e maior idade = %d e %d\n", menorIdade, maiorIdade);
		System.out.printf("Salarios de mulheres acima de R$ 3000.00 = %d\n", acimaTresMil);

		s.close();
	}
}
