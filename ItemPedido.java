public class ItemPedido {
    Produto produto;
    int quantidade;
    double subtotal;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.preco * quantidade; // Calcula o subtotal na criação
    }
}