package heranca.exercicios.ex6;

public class Main {
    public static void main(String[] args) {
        // Para fazer sobreescrita de um metodo, você precisa de um refazer a assinatura do
        // metodo na classe filho e conocar a anotação @overide nele.

        // Todos os animais podem emitir som, porem apenas
        // humanos (sendo animais) podem falar o seu nome quando emite som

        Animal animal = new Animal();
        Pessoa pessoa = new Pessoa("João");

        animal.emitirSom();
        pessoa.emitirSom();
    }
}
