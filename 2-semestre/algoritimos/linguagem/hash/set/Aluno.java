package set;

import java.util.HashSet;
import java.util.Set;

public record Aluno(String nome, Set<String> emails, Set<String> telefones) {
    public Aluno(String nome) {
        this(nome, new HashSet<>(), new HashSet<>());
    }
}
