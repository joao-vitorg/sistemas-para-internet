import java.util.Scanner;

public class Ex1006 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    double primeiroNumero, segundoNumero, terceiroNumero, media;
	    
	    primeiroNumero = s.nextDouble();
	    segundoNumero = s.nextDouble();
        terceiroNumero = s.nextDouble();

		media = (primeiroNumero*2+segundoNumero*3+terceiroNumero*5) / (2+3+5);
		
		System.out.printf("MEDIA = %.1f\n", media);
        
        s.close();
	}
}
