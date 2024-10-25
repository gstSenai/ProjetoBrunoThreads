class Estoque {
    private int quantidade = 10;
    public synchronized boolean verificarEstoque(int quantidadeSolicitada) {
        if (quantidadeSolicitada <= quantidade) {
            quantidade -= quantidadeSolicitada;
            return true;
        }
        return false;
    }
}