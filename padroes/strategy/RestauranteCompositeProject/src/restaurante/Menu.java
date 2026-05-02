package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Menu implements ItemMenu {
    private String nome;
    private List<ItemMenu> itens = new ArrayList<>();

    public Menu(String nome) {
        this.nome = nome;
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
    }

    public void removerItem(ItemMenu item) {
        itens.remove(item);
    }

    @Override
    public void mostrarDescricao() {
        System.out.println("Menu: " + nome);
        for (ItemMenu item : itens) {
            item.mostrarDescricao();
        }
    }

    @Override
    public double calcularPreco() {
        double total = 0;
        for (ItemMenu item : itens) {
            total += item.calcularPreco();
        }
        return total;
    }
}
