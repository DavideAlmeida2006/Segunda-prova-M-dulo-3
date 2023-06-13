package classes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Venda {
    private LocalDate data;
    private Produto produto;
    private int qtdVendida;
    double valorVendido;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Venda (LocalDate data, Produto produto, int qtdVendida, double valorVendido){
        this.data = data;
        this.produto = produto;
        this.qtdVendida = qtdVendida;
        this.valorVendido = valorVendido;
    }

    @Override
    public String toString() {
        String txt = "";
        txt += produto + " | Data: " + data.format(df) +" | Quantidade vendida: " + qtdVendida + " | Valor vendido: R$" + valorVendido;     //tive problemas com o String.format :(
        return txt;

    }
    
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public int getQtdVendida() {
        return qtdVendida;
    }
    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    public double getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(double valorVendido) {
        this.valorVendido = valorVendido;
    }
    
}
