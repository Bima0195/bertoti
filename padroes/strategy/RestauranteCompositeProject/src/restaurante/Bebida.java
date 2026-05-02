package restaurante;

public class Bebida implements ItemMenu {
    private String nome;
    private double preco;

    public Bebida(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public void mostrarDescricao() {
        System.out.println("Bebida: " + nome + " - R$" + preco);
    }

    @Override
    public double calcularPreco() {
        return preco;
    }
}
