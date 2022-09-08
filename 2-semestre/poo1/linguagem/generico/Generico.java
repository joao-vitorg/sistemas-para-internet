import entities.Pessoa;

public class Generico {
    public static void main(String[] args) {
        Pessoa<Integer, Integer> integerIntegerPessoa = new Pessoa<>("joao", 1234, 56710);
        System.out.println(integerIntegerPessoa);

        Pessoa<Integer, String> integerStringPessoa = new Pessoa<>("joao", 1234, "567-10");
        System.out.println(integerStringPessoa);

        Pessoa<String, String> stringStringPessoa = new Pessoa<>("joao", "123-4", "567-10");
        System.out.println(stringStringPessoa);


        Pessoa<String, Integer> stringIntegerPessoa = new Pessoa<>("joao", "123-4", 56710);
        System.out.println(stringIntegerPessoa);
    }
}
