import java.util.Scanner;

public class Ex1002 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    double raioCirculo, area;
	    
	    raioCirculo = s.nextDouble();
		
		area = 3.14159*Math.pow(raioCirculo, 2);
		
		System.out.printf("A=%.4f\n", area);

        s.close();
	}
}
