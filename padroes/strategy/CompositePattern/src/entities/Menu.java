package entities;
import java.util.*;
public class Menu implements Componente { private List<Componente> itens=new ArrayList<>(); public void adicionarItem(Componente c){itens.add(c);} public String mostrarDescricao(){return "Menu";} public double calcularPreco(){ double t=0; for(Componente c:itens)t+=c.calcularPreco(); return t;} }