import java.util.Scanner;

public class Ex1004 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int primeiroNumero, segundoNumero, prod;
	    
	    primeiroNumero = s.nextInt();
	    segundoNumero = s.nextInt();

		
		prod = primeiroNumero*segundoNumero;
		
		System.out.println("PROD = " + prod);
        
        s.close();
	}
}
