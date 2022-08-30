import java.util.Scanner;

class Replace {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String texto = s.nextLine();
        texto = texto.replace('a', '@');
        texto = texto.replace('A', '@');

        String[] palavras = texto.split(" ");

        if (palavras.length < 3) {
            System.out.println("Frase invalida.");
            return;
        }

        System.out.println(texto);

        int comp = palavras[0].compareTo(palavras[palavras.length - 1]);

        System.out.printf("palavra1 %s palavra2\n",
                (comp == 0)
                        ? "=="
                        : (comp > 0)
                        ? ">"
                        : "<");
    }
}