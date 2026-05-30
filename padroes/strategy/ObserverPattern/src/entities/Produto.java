package entities;
import java.util.*;
public class Produto { private java.util.List<Observador> observadores=new ArrayList<>(); public void adicionar(Observador o){observadores.add(o);} public void setPreco(double preco){ for(Observador o:observadores){o.update(preco);} }}