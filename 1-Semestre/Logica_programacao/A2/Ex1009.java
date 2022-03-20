import java.util.Scanner;

public class Ex1009 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    double salario, vendasTotal, salarioComissao;
        
	    s.nextLine();
	    salario = s.nextDouble();
        vendasTotal = s.nextDouble();

		salarioComissao = salario+(vendasTotal*0.15);
		
		System.out.printf("TOTAL = R$ %.2f\n", salarioComissao);
        
        s.close();
	}
}
