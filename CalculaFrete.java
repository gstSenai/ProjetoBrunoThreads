class CalculaFrete implements Runnable {
    private String cidade;
    private Pedido pedido;
    private double valorFrete;
    private VerificaEstoque verificaEstoque;

    public CalculaFrete(String cidade, Pedido pedido, VerificaEstoque verificaEstoque) {
        this.cidade = cidade;
        this.pedido = pedido;
        this.verificaEstoque = verificaEstoque;
    }

    public void verificarFrete() {
        if (!verificaEstoque.estoqueSuficiente) {
            System.out.println("Frete não calculado: estoque insuficiente.");
            return;
        }

        switch (this.cidade) {
            case "Jaraguá do Sul":
                valorFrete = 10.5;
                break;
            case "Joinville":
                valorFrete = 15.5;
                break;
            case "Corupá":
                valorFrete = 25.0;
                break;
            default:
                System.out.println("Cidade não encontrada na lista de entrega");
                return;
        }

        System.out.println("Frete para " + cidade + " calculado: R$" + valorFrete);
        double resultadoSoma = pedido.valorTotal() + valorFrete;
        System.out.println("Preço total do pedido: R$" + resultadoSoma);
    }

    @Override
    public void run() {
        System.out.println("Calculando o frete...");
        try {
            Thread.sleep(2000);
            verificarFrete();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Frete calculado.");
    }
}
