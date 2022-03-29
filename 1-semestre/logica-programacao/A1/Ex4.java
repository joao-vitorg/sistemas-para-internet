import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String primeroNome, segundoNome;
        int primeiraIdade, segundaIdade;
        double mediaIdade;
        
        primeroNome = s.next();
        primeiraIdade = s.nextInt();
        
        segundoNome = s.next();
        segundaIdade = s.nextInt();
        
        mediaIdade = (primeiraIdade+segundaIdade)/2.0;
        
        System.out.println("A idade média de " + primeroNome + " e " + segundoNome + " é de " + mediaIdade + " anos");

        s.close();
    }
}