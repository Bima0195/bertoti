package entities;

public class Estudante extends Cliente{
	
	
	
	
	public Estudante() {
		
	}
	
	

	public Estudante(String nome) {
		super(nome);
	}


	@Override
	public void emprestimo() {
		System.out.println("Esse cliente não pode realizar emprestimo");
	}

}
