package tipoTriangulo.entities;

public class Triangulo {
    private int a;
    private int b;
    private int c;

    public Triangulo(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String tipoTriangulo() {
        if (a == b && b == c) return "Equilátero";
        if (a != b && b != c && a != c) return "Escaleno";
        return "Isósceles";
    }

    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
