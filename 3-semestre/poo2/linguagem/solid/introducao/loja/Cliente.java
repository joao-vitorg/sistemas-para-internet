package solid.introducao.loja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
    private final List<Produto> carrinho = new ArrayList<>();
    private final List<Venda> compras = new ArrayList<>();
    private String nome;
    private String endereco;
    private final LojaVirtual lojaVirtual;

    public Cliente(String nome, String endereco, LojaVirtual lojaVirtual) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojaVirtual = lojaVirtual;
    }

    public void adicionarCarrinho(Produto produto) {
        carrinho.add(produto);
    }

    public void removerCarrinho(Produto produto) {
        carrinho.remove(produto);
    }

    public void comprar() {
        Venda venda = new Venda(carrinho);

        compras.add(venda);
        lojaVirtual.adicionarVenda(venda);
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

    public List<Produto> getCarrinho() {
        return Collections.unmodifiableList(carrinho);
    }

    public List<Venda> getCompras() {
        return Collections.unmodifiableList(compras);
    }

    @Override
    public String toString() {
        return carrinho.toString();
    }
}
