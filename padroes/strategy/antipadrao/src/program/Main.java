package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Aposentado;
import entities.Cliente;
import entities.ClienteComum;
import entities.Empresa;
import entities.Estudante;

public class Main {
	
	public static void main(String[] args) {
		
		Cliente cli = new Cliente();
		Cliente comum = new ClienteComum("Fernando");
		
		System.out.println(comum);
		comum.emprestimo();
		
	
		
		
		
	
		
	}

}











/*package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Aposentado;
import entities.Cliente;
import entities.ClienteComum;
import entities.Empresa;
import entities.Estudante;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		List<Cliente> list = new ArrayList<>();
		
		System.out.print("Informe a quantidade de cliente: ");
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			System.out.println("Datos do cliente #" + i + ":");
			System.out.print("Comum, Aposentado, Empresa, ou Estudante (c/a/em/es)? ");
			String tipo = sc.next();
			System.out.print("Nome: ");
			String nome = sc.next();	
			
			if(tipo.equals("c")) 
				list.add(new ClienteComum(nome));
			
			if(tipo.equals("a")) 
				list.add(new Aposentado(nome));
			
			if(tipo.equals("em")) 
				list.add(new Empresa(nome));
			
			if(tipo.equals("es")) 
				list.add(new Estudante(nome));				
			
		}
		
		System.out.println();
		for(Cliente cli: list) {
			System.out.print(cli.getNome()+", ");
			cli.emprestimo();
			
		
		}
		
		sc.close();
		
	}

}*/
















