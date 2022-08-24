import entities.FigurasGeometricas;

import java.util.Scanner;

public class Application {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1 - Circulo");
            System.out.println("2 - Triângulo");
            System.out.println("3 - Quadrado");
            System.out.println("4 - Sair");

            System.out.print("DIGITE A OPÇÃO: ");
            int op = s.nextInt();

            if (op == 1) circulo();
            else if (op == 2) triangulo();
            else if (op == 3) quadrado();
            else if (op == 4) break;
        }
    }

    private static void circulo() {
        System.out.print("\nDigite o xc: ");
        double xc = s.nextDouble();

        System.out.print("Digite o yc: ");
        double yc = s.nextDouble();

        System.out.print("Digite a raio: ");
        double raio = s.nextDouble();

        FigurasGeometricas figura;
        figura = new FigurasGeometricas(xc, yc, raio);

        figura.exibeCirculo();
    }

    private static void triangulo() {
        System.out.print("\nDigite a base: ");
        double base = s.nextDouble();

        System.out.print("Digite a altura: ");
        double altura = s.nextDouble();

        FigurasGeometricas figura = new FigurasGeometricas(base, altura);
        figura.exibeTriangulo();
    }

    private static void quadrado() {
        System.out.print("\nDigite a largura: ");
        double largura = s.nextDouble();

        FigurasGeometricas figura = new FigurasGeometricas(largura);
        figura.exibeQuadrado();
    }
}
