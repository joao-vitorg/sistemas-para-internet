import java.util.Scanner;

public class Ex1005 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    double primeiroNumero, segundoNumero, media;
	    
	    primeiroNumero = s.nextDouble();
	    segundoNumero = s.nextDouble();

		media = (primeiroNumero*3.5+segundoNumero*7.5) / (3.5+7.5);
		
		System.out.printf("MEDIA = %.5f\n", media);
        
        s.close();
	}
}
