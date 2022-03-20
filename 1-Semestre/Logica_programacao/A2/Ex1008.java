import java.util.Scanner;

public class Ex1008 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int numeroFuncionario, horasTrabalhadas;
	    double dinheiroHora, salario;
	    
	    numeroFuncionario = s.nextInt();
	    horasTrabalhadas = s.nextInt();
        dinheiroHora = s.nextDouble();

		salario = horasTrabalhadas*dinheiroHora;
		
		System.out.println("NUMBER = " + numeroFuncionario);
		System.out.printf("SALARY = U$ %.2f\n", salario);
        
        s.close();
	}
}
