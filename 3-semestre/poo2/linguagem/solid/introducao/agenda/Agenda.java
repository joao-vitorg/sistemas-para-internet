package solid.introducao.agenda;

import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class Agenda {
    private final HashMap<String, Contato> contatos = new HashMap<>();

    public void adicionar(Contato contato) {
        if (contatos.containsKey(contato.nome())) throw new InputMismatchException();
        contatos.put(contato.nome(), contato);
    }

    public Contato buscar(String nome) {
        return contatos.get(nome);
    }

    public Contato excluir(String nome) {
        return contatos.remove(nome);
    }

    public void atualizar(Contato contato) {
        if (!contatos.containsKey(contato.nome())) throw new InputMismatchException();
        contatos.put(contato.nome(), contato);
    }

    public Map<String, Contato> getContatos() {
        return Collections.unmodifiableMap(contatos);
    }

    @Override
    public String toString() {
        return contatos.toString();
    }
}
