package linguagem.heranca;

public class Animal {
    private String nome;
    private float comprimento;
    private int patas;
    private String cor;
    private String ambiente;
    private float velocidadeMedia;

    public Animal(String nome, float comprimento, int patas, String cor, String ambiente, float velocidadeMedia) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.patas = patas;
        this.cor = cor;
        this.ambiente = ambiente;
        this.velocidadeMedia = velocidadeMedia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public float getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(float velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public void dado() {
        String sb = "Animal{" + "nome='" + nome + '\'' +
                ", comprimento=" + comprimento +
                ", patas=" + patas +
                ", cor='" + cor + '\'' +
                ", ambiente='" + ambiente + '\'' +
                ", velocidadeMedia=" + velocidadeMedia +
                '}';
        System.out.println(sb);
    }
}
