class Produto {
    int idProduto;
    String nome;
    double preco;
    String categoria;
    int estoque;

    public Produto(int idProduto, String nome, double preco, String categoria, int estoque) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.estoque = estoque;
    }

    public void atualizarEstoque(int quantidade) { // Se a quantidade for positiva, adiciona ao estoque. caso contrario subtrai.
        this.estoque += quantidade;
    }

    public void exibirProduto() {
        System.out.println("[" + idProduto + "] " + nome + " | Categoria: " + categoria + 
                           " | Preço: R$" + preco + " | Estoque: " + estoque);
    }
}

class ListaProdutos { // Estrutura para o Catálogo dos Produtos
    class No {
        Produto valor;
        No proximo;

        No(Produto valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    No inicio;
    int tamanho;

    public void inserirFim(Produto produto) {
        No novo = new No(produto);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    public Produto buscarPorId(int id) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor.idProduto == id) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void exibirCatalogo() { // Método auxiliar para listar todos os produtos do menu
        No atual = inicio;
        if (atual == null) {
            System.out.println("Catálogo vazio.");
            return;
        }
        System.out.println("--- CATÁLOGO DE PRODUTOS ---");
        while (atual != null) {
            atual.valor.exibirProduto();
            atual = atual.proximo;
        }
    }
}