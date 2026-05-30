package application;

import controller.LojaController;

/**
 * Classe principal da aplicação.
 */
public class Main {
    public static void main(String[] args) {
        LojaController controller = new LojaController();
        controller.executar();
    }
}
