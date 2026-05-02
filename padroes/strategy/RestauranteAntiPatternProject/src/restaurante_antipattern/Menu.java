package restaurante_antipattern;

public class Menu extends ItemPedido {

    public Menu(String nome, double preco) {
        super(nome, preco, "Menu");
    }

    public void montarCombo() {
        System.out.println("Montando combo.");
    }
}
