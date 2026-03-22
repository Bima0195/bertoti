package entities;

public class ClienteA implements Observer {
    public void update(double preco) {
        System.out.println("Cliente A: Notificação no app - Novo preço: " + preco);
    }
}
