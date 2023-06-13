package classes;

public class Produto {

    private String codigo;
    private String nome;
    private double valor;
    private int qtd;

    public Produto(String codigo, String nome, double valor, int qtd) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return String.format("Código do produto: %s. |  Produto: %s. | Valor: R$%.2f. | Quantidade em estoque: %d." ,codigo, nome, valor, qtd);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

}
