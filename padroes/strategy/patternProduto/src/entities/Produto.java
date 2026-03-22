package entities;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private double preco;
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) {
        observers.add(o);
    }

    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    public void setPreco(double preco) {
        this.preco = preco;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(preco);
        }
    }
}