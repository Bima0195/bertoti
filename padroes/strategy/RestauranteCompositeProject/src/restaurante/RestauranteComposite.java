package restaurante;

public class RestauranteComposite {
    public static void main(String[] args) {

        Prato pizza = new Prato("Pizza Margherita", 35.0);
        Bebida suco = new Bebida("Suco de Laranja", 8.0);

        Menu comboAlmoco = new Menu("Combo Almoço");
        comboAlmoco.adicionarItem(pizza);
        comboAlmoco.adicionarItem(suco);

        comboAlmoco.mostrarDescricao();
        System.out.println("Preço total: R$" + comboAlmoco.calcularPreco());
    }
}
