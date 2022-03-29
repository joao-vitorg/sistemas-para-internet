import java.util.Scanner;

public class Ex1014 {
    public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int distancia;
	    double gasolinaGasta, quilometroLitro;

        distancia = s.nextInt();
        gasolinaGasta = s.nextDouble();
        quilometroLitro = distancia/gasolinaGasta;

		System.out.printf("%.3f km/l\n", quilometroLitro);
        
        s.close();
	}
}
