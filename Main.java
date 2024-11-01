public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Pedido pedido = new Pedido(9, 50.0);

        VerificaEstoque verificaEstoque = new VerificaEstoque(estoque, pedido);
        CalculaFrete calculaFrete = new CalculaFrete("Jaraguá do Sul", pedido, verificaEstoque);
        EnviaEmailConfirmacao enviaEmail = new EnviaEmailConfirmacao();

        Thread threadVerificaEstoque = new Thread(verificaEstoque);
        Thread threadCalculaFrete = new Thread(calculaFrete);
        Thread threadEnviaEmail = new Thread(enviaEmail);

        System.out.println("Processando Produto...\n");
        threadVerificaEstoque.start();

        try {
            threadVerificaEstoque.join();
            if (verificaEstoque.estoqueSuficiente) {
                threadCalculaFrete.start();
                threadEnviaEmail.start();

                threadCalculaFrete.join();
                threadEnviaEmail.join();
            } else {
                System.out.println("Pedido não pode ser processado: estoque insuficiente.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n...Processamento Finalizado");
    }
}