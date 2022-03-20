import java.util.Scanner;

public class Ex1003 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int primeiroNumero, segundoNumero, soma;
	    
	    primeiroNumero = s.nextInt();
	    segundoNumero = s.nextInt();

		
		soma = primeiroNumero+segundoNumero;
		
		System.out.println("SOMA = " + soma);
        
        s.close();
	}
}
