package entities;

public class Aposentado extends Cliente{
	
	public Aposentado() {
	}
	
	public Aposentado(String nome) {
		super(nome);
	}

	
	@Override
	public void emprestimo() {
		System.out.println("Esse cliente pode realizar emprestimo");
		
	}

	

}
