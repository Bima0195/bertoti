package entities;

public class ClienteComum extends Cliente{
	
	
	public ClienteComum() {
	}
	
	public ClienteComum(String nome) {
		super(nome);
	}
	
	
	@Override
	public void emprestimo() {
		System.out.println("Esse cliente não pode realizar emprestimo");
	}

}
