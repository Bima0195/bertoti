package entities;

public class Empresa extends Cliente{
	
	
	
	public Empresa() {
		
	}
	
	

	public Empresa(String nome) {
		super(nome);
	}


	@Override
	public void emprestimo() {
		System.out.println("Esse cliente pode realizar emprestimo");
	}

}
