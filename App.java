public class App {
    public static void main(String[] args) throws Exception {

        // Criando e populando o Catálogo de Produtos
        ListaProdutos catalogo = new ListaProdutos();
        
        Produto p1 = new Produto(1, "Whey Protein", 120.50, "Suplementação", 50);
        Produto p2 = new Produto(2, "Creatina", 85.00, "Suplementação", 30);
        Produto p3 = new Produto(3, "Kit Arduino Uno R3", 150.00, "Eletrônicos", 15);
        
        catalogo.inserirFim(p1);
        catalogo.inserirFim(p2);
        catalogo.inserirFim(p3);
        
        System.out.println("--- CATÁLOGO DE PRODUTOS ---");
        catalogo.exibirCatalogo();

        // Criando e Cadastrando Clientes
        ListaClientes clientes = new ListaClientes();
        
        Cliente c1 = new Cliente();
        c1.cadastrar(101, "Cauã", "91 98765-4321", "Rua 1, Alameda Principal");
        clientes.inserirFim(c1);
        
        System.out.println("\n--- CLIENTE CADASTRADO ---");
        c1.exibirDados();
        
        // Criando Itens para o Pedido
        // Selecionando 2 unidades do Produto 1 e 1 unidade do Produto 3
        ItemPedido item1 = new ItemPedido(p1, 2); 
        ItemPedido item2 = new ItemPedido(p3, 1);
        
        // Montando o Pedido
        // Passando uma string vazia "" no endereço para testar a sua lógica de puxar o endereço do cliente
        Pedido pedido1 = new Pedido(00001, c1, ""); 
        
        pedido1.adicionarItem(item1);
        pedido1.adicionarItem(item2);
        
        System.out.println("\n--- RESUMO DO PEDIDO ANTES DE FINALIZAR ---");
        pedido1.exibirResumo();
        
        // Testando a remoção de um item
        // Simulando que o cliente desistiu do item 2
        pedido1.removerItem(item2);
        System.out.println("\n--- RESUMO DO PEDIDO APÓS REMOVER ITEM ---");
        pedido1.exibirResumo();
        
        // Finalizando o Pedido
        pedido1.finalizarPedido();
        System.out.println("\n--- PEDIDO FINALIZADO ---");
        pedido1.exibirResumo();
    }
}
