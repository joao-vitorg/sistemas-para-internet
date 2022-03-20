import java.util.Scanner;

public class Ex1001 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int primeiroNumero, SegundoNumero, soma;
        
        primeiroNumero = s.nextInt();
        SegundoNumero = s.nextInt();
        
        soma = primeiroNumero+SegundoNumero;
        
        System.out.println("X = " + soma);

        s.close();
    }
}
