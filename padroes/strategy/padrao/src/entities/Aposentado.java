package entities;

public class Aposentado extends Cliente implements Emprestimo{
	
	public Aposentado() {
	}
	
	public Aposentado(String nome) {
		super(nome);
	}

	
	@Override
	public String emprestar() {
		return "Esse cliente pode realizar emprestimo";
		
	}
	
	@Override
	public String toString() {
		return "Cliente: "
				+getNome()
				+emprestar();
	}

	

}
