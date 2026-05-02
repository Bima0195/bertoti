package restaurante;

public class Prato implements ItemMenu {
    private String nome;
    private double preco;

    public Prato(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public void mostrarDescricao() {
        System.out.println("Prato: " + nome + " - R$" + preco);
    }

    @Override
    public double calcularPreco() {
        return preco;
    }
}
