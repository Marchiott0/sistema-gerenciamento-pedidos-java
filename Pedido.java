public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private String status;
    private double valorTotal;
    private String enderecoEntrega;
    private ListaItens listaDeItens;

    public Pedido(int idPedido, Cliente cliente, String enderecoEntrega) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.status = "Criado";
        this.valorTotal = 0.0;
        // Usa o endereço do cliente se nenhum for informado
        this.enderecoEntrega = (enderecoEntrega == null || enderecoEntrega.isEmpty()) 
                               ? cliente.endereco : enderecoEntrega;
        this.listaDeItens = new ListaItens();
    }

    public void adicionarItem(ItemPedido item) {
        listaDeItens.inserirFim(item);
        calcularTotal();
    }

    public void removerItem(ItemPedido item) {
        listaDeItens.remover(item);
        calcularTotal();
    }

    public void calcularTotal() {
        this.valorTotal = 0.0;
        NoItem atual = listaDeItens.getInicio();
        while (atual != null) {
            // Acessa o subtotal do ItemPedido armazenado no nó
            this.valorTotal += atual.valor.subtotal;
            atual = atual.proximo;
        }
    }

    public void finalizarPedido() {
        this.status = "Finalizado/Entregue";
    }

    public void exibirResumo() {
        System.out.println("\n--- RESUMO DO PEDIDO #" + idPedido + " ---");
        System.out.println("Status: " + status);
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("Endereço de Entrega: " + enderecoEntrega);
        System.out.println("Itens:");
        
        NoItem atual = listaDeItens.getInicio();
        if (atual == null) {
            System.out.println("  (Nenhum item adicionado)");
        }
        while (atual != null) {
            System.out.println("  - " + atual.valor.quantidade + "x " + atual.valor.produto.nome 
                               + " (Subtotal: R$" + atual.valor.subtotal + ")");
            atual = atual.proximo;
        }
        System.out.println("VALOR TOTAL: R$" + valorTotal);
        System.out.println("-------------------------------\n");
    }

    public int getIdPedido() { return idPedido; }
    public String getStatus() { return status; }
}

// Estas classes podem ficar no final do arquivo Pedido.java, desde que não sejam 'public'
class NoItem {
    ItemPedido valor;
    NoItem proximo;
    NoItem(ItemPedido valor) { 
        this.valor = valor; 
        this.proximo = null; 
    }
}

class ListaItens {
    private NoItem inicio;

    public void inserirFim(ItemPedido valor) {
        NoItem novo = new NoItem(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            NoItem atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public void remover(ItemPedido valor) {
        if (inicio == null) return;
        if (inicio.valor == valor) {
            inicio = inicio.proximo;
            return;
        }
        NoItem atual = inicio;
        while (atual.proximo != null) {
            if (atual.proximo.valor == valor) {
                atual.proximo = atual.proximo.proximo;
                return;
            }
            atual = atual.proximo;
        }
    }

    public NoItem getInicio() { return inicio; }
}