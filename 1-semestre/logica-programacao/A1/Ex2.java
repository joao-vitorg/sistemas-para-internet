import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double pesoUsuario, alturaUsuario, imc;
        
        pesoUsuario = s.nextDouble();
        alturaUsuario = s.nextDouble();

        imc = pesoUsuario/(Math.pow(alturaUsuario, 2));
        
        System.out.println(imc);

        s.close();
    }
}