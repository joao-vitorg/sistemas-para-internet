package composicao.etapa1;

public class Consulta {
    private String nomeAnimal, observacoes, queixa, hisorico;

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

    @Override
    public String toString() {
        return "Consulta{" + "nomeAnimal='" + nomeAnimal + '\'' + ", observacoes='" + observacoes + '\'' + ", queixa='" + queixa + '\'' + ", hisorico='" + hisorico + '\'' + '}';
    }
}
