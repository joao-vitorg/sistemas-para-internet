import java.util.Scanner;

public class Ex1007 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int primeiroNumero, segundoNumero, terceiroNumero, quartoNumero, diferenca;
	    
	    primeiroNumero = s.nextInt();
	    segundoNumero = s.nextInt();
        terceiroNumero = s.nextInt();
        quartoNumero = s.nextInt();

		diferenca = primeiroNumero*segundoNumero - terceiroNumero*quartoNumero;
		
		System.out.println("DIFERENCA = " + diferenca);
        
        s.close();
	}
}
