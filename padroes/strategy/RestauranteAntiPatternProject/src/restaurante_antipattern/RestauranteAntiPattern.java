package restaurante_antipattern;

public class RestauranteAntiPattern {
    public static void main(String[] args) {

        Prato pizza = new Prato("Pizza", 30.0);
        Bebida suco = new Bebida("Suco", 7.0);
        Menu combo = new Menu("Combo", 0.0);

        pizza.mostrarDescricao();
        suco.mostrarDescricao();
        combo.mostrarDescricao();

        // Chamando métodos que não fazem sentido
        pizza.adicionarItem(suco); // errado
        suco.removerItem(pizza);   // errado
    }
}
