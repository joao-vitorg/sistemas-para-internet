package set;

import java.util.HashSet;
import java.util.Set;

public class Aluno {
    public final Set<String> emails = new HashSet<>();
    public final Set<String> telefones = new HashSet<>();
    private final String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", emails=" + emails +
                ", telefones=" + telefones +
                '}';
    }
}
