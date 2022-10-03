package entities;

public class JogadorDeFutebol {
    public final String nome;
    public final String nascimenento;
    public final String altura;
    public final String peso;
    public final String nacionalidade;
    public final String posicao;

    public JogadorDeFutebol(String nome, String nascimenento, String altura, String peso, String nacionalidade, String posicao) {
        this.nome = nome;
        this.nascimenento = nascimenento;
        this.altura = altura;
        this.peso = peso;
        this.nacionalidade = nacionalidade;
        this.posicao = posicao;
    }

    public int calculaIdade() {
        return 2022 - Integer.parseInt(nascimenento.substring(6, 10));
    }

    public String calculaAposentadoria() {
        int idade = calculaIdade();

        int aposentar = switch (posicao) {
            case "atacante" -> 35 - idade;
            case "defesa" -> 40 - idade;
            case "meio de campo" -> 38 - idade;
            default -> 0;
        };

        return String.format("Faltam %d anos para o jogador %s se aposentar.", aposentar, nome);
    }

    @Override
    public String toString() {
        return String.format("""
                Nome: %s
                Data de Nascimento: %s
                Altura: %s m
                Peso: %s kg
                Nacionalidade: %s
                Posição: %s""", nome, nascimenento, altura, peso, nacionalidade, posicao);
    }
}
