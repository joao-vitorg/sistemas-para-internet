import java.util.Scanner;

public class Ex1012 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    double a, b, c;

        a = s.nextDouble();
        b = s.nextDouble();
        c = s.nextDouble();

		System.out.printf("TRIANGULO: %.3f\n", ((a*c)/2));
		System.out.printf("CIRCULO: %.3f\n", 3.14159*c*c);
		System.out.printf("TRAPEZIO: %.3f\n", ((a+b)*c)/2);
		System.out.printf("QUADRADO: %.3f\n", b*b);
		System.out.printf("RETANGULO: %.3f\n", a*b);
        
        s.close();
	}
}
