package restaurante_antipattern;

public class Bebida extends ItemPedido {

    public Bebida(String nome, double preco) {
        super(nome, preco, "Bebida");
    }

    public void prepararBebida() {
        System.out.println("Preparando bebida.");
    }
}
