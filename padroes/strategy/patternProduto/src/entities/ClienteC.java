package entities;

public class ClienteC implements Observer {
    public void update(double preco) {
        System.out.println("Cliente C: Atualizando sistema - Novo preço: " + preco);
    }
}