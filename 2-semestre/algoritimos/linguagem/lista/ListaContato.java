import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaContato {
    private static final Scanner s = new Scanner(System.in);
    private static final List<Contato> lista = new ArrayList<>();

    public static void main(String[] args) {
        for (int op = 0; op != 4; ) {
            imprimeMenu();

            op = s.nextInt();
            s.nextLine();

            if (op == 1) {
                inserirContato();
            } else if (op == 2) {
                listarContato();
            }
        }
    }

    public static void imprimeMenu() {
        System.out.print("""
                                    
                1 - Inserir Contato
                2 - Listar Contatos
                3 - Sair
                                    
                Opção:\040""");
    }

    public static void inserirContato() {
        System.out.print("\nNome: ");
        String nome = s.nextLine();
        System.out.print("Telefone: ");
        String telefone = s.nextLine();
        System.out.print("Celular: ");
        String celular = s.nextLine();
        System.out.print("E-mail: ");
        String email = s.nextLine();

        lista.add(new Contato(nome, telefone, celular, email));
    }

    public static void listarContato() {
        System.out.println();
        lista.forEach(System.out::println);
    }
}
