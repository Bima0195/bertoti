package restaurante_antipattern;

public class ItemPedido {
    protected String nome;
    protected double preco;
    protected String tipo; // "Prato", "Bebida", "Menu"

    public ItemPedido(String nome, double preco, String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public void mostrarDescricao() {
        System.out.println(tipo + ": " + nome + " - R$" + preco);
    }

    public double calcularPreco() {
        return preco;
    }

    // Métodos sem sentido para todos os tipos
    public void adicionarItem(ItemPedido p) {
        System.out.println("Adicionando item (mesmo se não for menu)");
    }

    public void removerItem(ItemPedido p) {
        System.out.println("Removendo item (mesmo se não for menu)");
    }
}
