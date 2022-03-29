import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primeiraNota, segundaNota, terceiraNota;
		double mediaNota;
		String resposta;

		primeiraNota = s.nextInt();
		segundaNota = s.nextInt();
		terceiraNota = s.nextInt();
		
		mediaNota = (primeiraNota+segundaNota+terceiraNota)/3.0;

		resposta  = (mediaNota>=7) ? "O aluno foi Aprovado" : 
					(mediaNota>5) ? "O aluno está de Recuperação" : "O aluno está Reprovado";

		System.out.println(resposta);
		
		s.close();
	}
}