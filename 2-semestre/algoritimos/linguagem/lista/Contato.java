public class Contato {
    private final String nome;
    private final String telefone;
    private final String celular;
    private final String email;

    public Contato(String nome, String telefone, String celular, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
