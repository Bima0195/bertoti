package application;
import entities.*;
public class Main { public static void main(String[] args){ Menu m=new Menu(); m.adicionarItem(new Prato()); m.adicionarItem(new Bebida()); System.out.println(m.calcularPreco()); }}