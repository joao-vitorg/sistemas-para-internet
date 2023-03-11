package linguagem.heranca;

public class Mamifero extends Animal {
    private String alimento;

    public Mamifero(String nome, float comprimento, int patas, String cor, String ambiente, float velocidadeMedia, String alimento) {
        super(nome, comprimento, patas, cor, ambiente, velocidadeMedia);
        this.alimento = alimento;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public void dadosMamifero() {
        super.dado();

        String sb = "Mamifero{" + "alimento='" + alimento + '\'' + '}';
        System.out.println(sb);
    }
}
