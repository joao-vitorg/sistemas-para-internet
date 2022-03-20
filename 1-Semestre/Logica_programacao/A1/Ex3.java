import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double baseRetangulo, alturaRetangulo, diagonal, perimetro, area;

        baseRetangulo = s.nextDouble();
        alturaRetangulo = s.nextDouble();

        area = baseRetangulo*alturaRetangulo;
        perimetro = 2*(baseRetangulo+alturaRetangulo);
        diagonal = Math.sqrt(Math.pow(baseRetangulo, 2) + Math.pow(alturaRetangulo, 2));

        System.out.println("AREA = " + area);
        System.out.println("PERIMETRO = " + perimetro);
        System.out.println("DIAGONAL = " + diagonal);

        s.close();
    }
}