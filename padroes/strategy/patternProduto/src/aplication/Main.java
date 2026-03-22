package aplication;

import entities.ClienteA;
import entities.ClienteB;
import entities.ClienteC;
import entities.Produto;

public class Main {
	public static void main(String[] args) {
		Produto produto = new Produto();

		ClienteA a = new ClienteA();
		ClienteB b = new ClienteB();
		ClienteC c = new ClienteC();

		produto.subscribe(a);
		produto.subscribe(b);
		produto.subscribe(c);

		produto.setPreco(99.90);
	}
}
