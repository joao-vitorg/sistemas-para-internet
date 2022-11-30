package composicao.etapa3;

import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private String nomeAnimal, observacoes, queixa, hisorico;
    private List<ItemReceita> items = new ArrayList<>();

    public Consulta() {
    }

    public Consulta(String nomeAnimal, String observacoes, String queixa, String hisorico) {
        this.nomeAnimal = nomeAnimal;
        this.observacoes = observacoes;
        this.queixa = queixa;
        this.hisorico = hisorico;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getQueixa() {
        return queixa;
    }

    public void setQueixa(String queixa) {
        this.queixa = queixa;
    }

    public String getHisorico() {
        return hisorico;
    }

    public void setHisorico(String hisorico) {
        this.hisorico = hisorico;
    }

    public List<ItemReceita> getItems() {
        return items;
    }

    public void addItem(double dose, int duracao, Remedio remedio) {
        items.add(new ItemReceita(dose, duracao, remedio));
    }

    @Override
    public String toString() {
        return "Consulta{" + "nomeAnimal='" + nomeAnimal + '\'' + ", observacoes='" + observacoes + '\'' + ", queixa='" + queixa + '\'' + ", hisorico='" + hisorico + '\'' + ", items=" + items + '}';
    }
}
