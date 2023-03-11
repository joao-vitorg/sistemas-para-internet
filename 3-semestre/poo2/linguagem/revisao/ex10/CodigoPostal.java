package linguagem.revisao.ex10;

public class CodigoPostal {
    private int indicativo;
    private int extensao;
    private String nomeDaZona;

    public CodigoPostal() {
    }

    public CodigoPostal(int indicativo, int extensao, String nomeDaZona) {
        this.indicativo = indicativo;
        this.extensao = extensao;
        this.nomeDaZona = nomeDaZona;
    }

    public String mostrar() {
        return String.format("%d-%d %s", indicativo, extensao, nomeDaZona);
    }

    public int getIndicativo() {
        return indicativo;
    }

    public void setIndicativo(int indicativo) {
        this.indicativo = indicativo;
    }

    public int getExtensao() {
        return extensao;
    }

    public void setExtensao(int extensao) {
        this.extensao = extensao;
    }

    public String getNomeDaZona() {
        return nomeDaZona;
    }

    public void setNomeDaZona(String nomeDaZona) {
        this.nomeDaZona = nomeDaZona;
    }
}
