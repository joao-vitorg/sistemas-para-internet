import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CalendarioChines {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<Integer, String> calendario = new HashMap<>();
        calendario.put(0, "Macaco");
        calendario.put(1, "Galo");
        calendario.put(2, "Cão");
        calendario.put(3, "Porco");
        calendario.put(4, "Rato");
        calendario.put(5, "Boi");
        calendario.put(6, "Tigre");
        calendario.put(7, "Coelho");
        calendario.put(8, "Dragão");
        calendario.put(9, "Serpente");
        calendario.put(10, "Cavalo");
        calendario.put(11, "Carneiro");

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(calendario.get(s.nextInt() % 12));
        }
    }
}
