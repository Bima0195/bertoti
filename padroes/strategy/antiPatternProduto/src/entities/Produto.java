package entities;

class Produto {
    private double preco;

    private ClienteA clienteA;
    private ClienteB clienteB;
    private ClienteC clienteC;

    public Produto(ClienteA a, ClienteB b, ClienteC c) {
        this.clienteA = a;
        this.clienteB = b;
        this.clienteC = c;
    }

    public void setPreco(double preco) {
        this.preco = preco;
        avisarClientes();
    }

    private void avisarClientes() {
        clienteA.update(preco);
        clienteB.update(preco);
        clienteC.update(preco);
    }
}