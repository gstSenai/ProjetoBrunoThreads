class VerificaEstoque implements Runnable {
    private Estoque estoque;
    private Pedido pedido;
    public boolean estoqueSuficiente = false;

    public VerificaEstoque(Estoque estoque, Pedido pedido) {
        this.estoque = estoque;
        this.pedido = pedido;
    }

    @Override
    public void run() {
        System.out.println("Verificando o estoque...");

        try {
            Thread.sleep(7000);
            estoqueSuficiente = estoque.verificarEstoque(pedido.getQuantidade());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (estoqueSuficiente) {
            System.out.println("Estoque suficiente para o pedido.");
        } else {
            System.out.println("Estoque insuficiente para o pedido.");
        }
    }
}