package entities;

public class Empresa extends Cliente implements Emprestimo{
	
	
	
	public Empresa() {
		
	}
	
	

	public Empresa(String nome) {
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
