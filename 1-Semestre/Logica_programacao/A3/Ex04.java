import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double altura, pesoIdeal;
		char sexo;
		
		altura = s.nextDouble();
		sexo = s.next().charAt(0);
		
		pesoIdeal = (sexo=='M') ? (72.7*altura-58) : 
					(sexo=='F') ? (62.1*altura-44.7) : 0;

		System.out.printf("O peso ideal é %.2f\n", pesoIdeal);

		s.close();
	}
}