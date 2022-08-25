package entities;

public class FigurasGeometricas {
    private double lado, base, altura, xc, yc, raio;

    public FigurasGeometricas(double lado) {
        this.lado = lado;
    }

    public FigurasGeometricas(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public FigurasGeometricas(double xc, double yc, double raio) {
        this.xc = xc;
        this.yc = yc;
        this.raio = raio;
    }

    public double areaQuadrado() {
        return lado * lado;
    }

    public double areaTriangulo() {
        return (base * altura) / 2;
    }

    public double areaCirculo() {
        return Math.PI * Math.pow(raio, 2);
    }

    public void exibeQuadrado() {
        System.out.printf("\nA área do Quadrado é %.4f\n\n", areaQuadrado());
    }

    public void exibeTriangulo() {
        System.out.printf("\nA área do Triângulo é %.4f\n\n", areaTriangulo());
    }

    public void exibeCirculo() {
        System.out.printf("\nA área do círculo de centro (%.2fx%.2f) e raio=%.2f é: %.4f\n\n", xc, yc, raio, areaCirculo());
    }
}
