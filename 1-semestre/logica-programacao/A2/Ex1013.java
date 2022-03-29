import java.util.Scanner;

public class Ex1013 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int a, b, c, primeiroMaior, segundoMaior;

        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();

        primeiroMaior = (a+b+Math.abs(a-b))/2;
        segundoMaior = (primeiroMaior+c+Math.abs(primeiroMaior-c))/2;

		System.out.printf("%d eh o maior\n", segundoMaior);
        
        s.close();
	}
}
