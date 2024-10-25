class Pedido {
    private int quantidade;
    private double preco;

    public Pedido(int quantidade, double preco) {
        this.quantidade = quantidade;
        this.preco = preco;
    }


    public double valorTotal(){
        return this.preco * this.quantidade;
    }


    public int getQuantidade() {
        return quantidade;
    }
}