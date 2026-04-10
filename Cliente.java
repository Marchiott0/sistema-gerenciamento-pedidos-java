class Cliente {
    int idCliente;
    String nome;
    String telefone;
    String endereco;

    public void cadastrar(int idCliente, String nome, String telefone, String endereco) { // Metodo para cadastro
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public void atualizarDados(String novoTelefone, String novoEndereco) { // Metodo para atualizar dados antigos/errados
        this.telefone = novoTelefone;
        this.endereco = novoEndereco;
    }

    public void exibirDados() {
        System.out.println("ID: " + idCliente + " | Nome: " + nome + " | Tel: " + telefone + " | End: " + endereco);
    }
}

class ListaClientes { // Estrutura para armazenar os clientes
    class No {
        Cliente valor;
        No proximo;

        No(Cliente valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    No inicio;
    int tamanho;

    public void inserirFim(Cliente cliente) {
        No novo = new No(cliente);
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

    public Cliente buscarPorId(int id) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor.idCliente == id) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return null;
    }
}