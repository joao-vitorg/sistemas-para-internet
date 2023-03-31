package polimorfimo.ex7;

public class Main {
    public static void main(String[] args) {
        Figura figura1 = new Circulo(10);
        Figura figura2 = new Retangulo(10, 20);
        Figura figura3 = new Triangulo(10, 20);

        System.out.println(figura1.calcularArea());
        System.out.println(figura2.calcularArea());
        System.out.println(figura3.calcularArea());
    }
}
