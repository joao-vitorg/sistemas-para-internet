import java.util.Scanner;

public class Ex1010 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int primeiraUnidade, segundaUnidade;
	    double primeroValor, segundoValor, valorTotal;
	    
	    s.nextInt();
	    primeiraUnidade = s.nextInt();
        primeroValor = s.nextDouble();

	    s.nextInt();
	    segundaUnidade = s.nextInt();
        segundoValor = s.nextDouble();

		valorTotal = primeiraUnidade*primeroValor + segundaUnidade*segundoValor;
		
		System.out.printf("VALOR A PAGAR: R$ %.2f\n", valorTotal);
        
        s.close();
	}
}
