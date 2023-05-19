package solid.introducao.loja;

import java.util.*;

public class LojaVirtual {
    private final Set<Produto> catalogo = new HashSet<>();
    private final List<Venda> vendas = new ArrayList<>();
    private String nome;
    private String endereco;

    public LojaVirtual(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void adicionarCatalogo(Produto produto) {
        catalogo.add(produto);
    }

    public void removerCatalogo(Produto produto) {
        catalogo.remove(produto);
    }

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public void removerVenda(Venda venda) {
        vendas.remove(venda);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Set<Produto> getCatalogo() {
        return Collections.unmodifiableSet(catalogo);
    }

    public List<Venda> getVendas() {
        return Collections.unmodifiableList(vendas);
    }

    @Override
    public String toString() {
        return catalogo.toString();
    }

    public double total() {
        return vendas.stream().mapToDouble(Venda::total).sum();
    }
}
