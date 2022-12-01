import java.util.ArrayList;
import java.util.List;

public class Venda {
    private final List<Produto> produtos;
    private String cliente;
    private String data;

    public Venda(String cliente, String data) {
        this.cliente = cliente;
        this.data = data;
        produtos = new ArrayList<>();
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double calcularTotal() {
        double sum = 0;
        for (Produto produto : produtos) {
            sum += produto.calcularValor();
        }

        return sum;
    }
}
