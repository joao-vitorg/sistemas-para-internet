package tipoTriangulo;

import tipoTriangulo.entities.Triangulo;
import tipoTriangulo.entities.ValidaTriangulo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[] lido = le();

        if (!ValidaTriangulo.valida(lido[0], lido[1], lido[2])) {
            System.out.println("Triangulo invalido");
            return;
        }

        Triangulo triangulo = new Triangulo(lido[0], lido[1], lido[2]);

        System.out.println(triangulo.tipoTriangulo());
    }

    private static int[] le() {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        return new int[]{a, b, c};
    }
}
