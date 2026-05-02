package restaurante_antipattern;

public class Prato extends ItemPedido {

    public Prato(String nome, double preco) {
        super(nome, preco, "Prato");
    }

    public void fazerPedidoEspecial() {
        System.out.println("Pedido especial para prato.");
    }
}
