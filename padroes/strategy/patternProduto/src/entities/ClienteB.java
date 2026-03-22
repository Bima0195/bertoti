package entities;

public class ClienteB implements Observer{
    public void update(double preco) {
        System.out.println("Cliente B: Enviando email - Novo preço: " + preco);
    }
}
