package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ControladorCarro {
    private static final Scanner sc = new Scanner(System.in);
    private static final HashSet<Carro> carroSet = new HashSet<>();
    private static final HashMap<String, Carro> placaMap = new HashMap<>();
    private static final HashMap<Integer, HashSet<Carro>> anoMap = new HashMap<>();
    private static final HashSet<String> marcaSet = new HashSet<>();

    public static void main(String[] args) {
        int op;

        do {
            System.out.print("""
                                    
                    1 - Cadastrar Carro
                    2 - Listar todos os Carros
                    3 - Consultar um carro pela placa
                    4 - Consultar vários carros pelo ano
                    5 - Listar as marcas de carros que foram cadastradas
                    6 - Sair
                                    
                    Opção:\040""");

            op = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (op) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> consultarPlaca();
                case 4 -> consultarAno();
                case 5 -> listarMarcas();
            }
        } while (op != 6);
    }

    private static void cadastrar() {
        System.out.print("Placa: ");
        String placa = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("ano: ");
        int ano = sc.nextInt();

        Carro carro = new Carro(placa, marca, modelo, ano);

        carroSet.add(carro);
        marcaSet.add(marca);
        placaMap.put(placa, carro);

        if (!anoMap.containsKey(ano)) anoMap.put(ano, new HashSet<>());
        anoMap.get(ano).add(carro);
    }

    private static void listar() {
        carroSet.forEach(System.out::println);
    }

    private static void consultarPlaca() {
        System.out.print("Placa: ");
        Carro carro = placaMap.get(sc.nextLine());

        System.out.println(carro != null ? carro : "CARRO NÃO ENCONTRADO");
    }

    private static void consultarAno() {
        System.out.print("Ano: ");
        int ano = sc.nextInt();

        anoMap.get(ano).forEach(System.out::println);
    }

    private static void listarMarcas() {
        marcaSet.forEach(System.out::println);
    }
}
