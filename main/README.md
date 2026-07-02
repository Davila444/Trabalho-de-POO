# Sistema de vendas online 

# descrição_geral
### Ele estrutura como a plataforma gerencia o catálogo de produtos, controla os acessos de usuários (divididos entre clientes e administradores) e orquestra o fluxo de compras, desde a seleção de itens em um carrinho até a consolidação de um pedido e seu respectivo pagamento.
## regras_de_negocio
### gestao de perfis: ninguém é apenas usuario, ou você é um gerente(que manipula o estoque) ou um cliente(quem compra os produtos)

### controle_carrinho: O cliente possui um carrinho temporario, ele n guarda itens diretamente, mas sim um itemCarrinho, que registra a quantidade do produto antes da compra.

### Historico_pedido: Quando a compra é finalizada cria-se um pedido que armazena o preço unitario do produto, assim o produto unitario não muda ao final da compra.

### Contratos_pagamento: O sistema utiliza interfaces para garantir contratos. O carrinho e o pedido implementam uma interface comum para calcular o total

## detalhamento_de_classes:

### Nucleo do sistema: LojaOnline, a Classe principal que controla a plataforma.

### Usuarios: «abstract» Usuario, Base comum de informações e ações de autenticação para quem acessa o sistema.
### Administrador: Gerencia a plataforma e os itens ofertados.

### Cliente: O consumidor final.

### Produto: Representa a entidade base dos itens a venda.

### Carrinho: Objeto temporário que agrupa a intenção de compra do cliente.
### ItemCarrinho: Representa a relação entre o carrinho e o produto desejado para a compra atual.
### Pedido: O registro efetivado da compra, atrelado ao histórico definitivo do cliente.
### ItemPedido: O registro histórico individual de cada linha (item) consolidada no pedido.

### «interface» IPagamento: Contrato que exige a implementação padronizada do processamento de fundos.
### Pagamento: Concretiza os dados e o status da transação gerada pela finalização do pedido.

# Explicando como os conceitos de POO serão aplicados no nosso sistema:

## Encapsulamento: 
### Vamos usar o encapsulamento, já que todos os atributos das classes são privados, ou seja, ós vamos precisar de getters e setters para acessá-los.

## Herança:
### Usaremos herança em usuário, e cliente e administrador herdaram os atributos dessa entidade abstrata.

## Polimorfismo:
### Nos comportamentos de usuário, pois são diferentes(em atualizarDados()por exemplo, ambos atualizam, mas de frma diferente), apesar de herdarem de usuário.

## Abstração:
### Temos abstração em usuário e produto, porque não faz sentido criar um usuário genérico ou um produto genérico. Sempre temos tipos de usuários e tipos de produtos.

## Interfaces:
### Criamos as interfaces para FazerCalculo(Para ser implementada em pedido e carrinho, já que em ambos temos o calcularTotal()) e Pagamento(Porque há mais de um tipo de pagamento, como pix, boleto e cartão).

## Tratamento de excessões
### Usaremos o tratamento de excessões caso o cliente tente comprar algo com estoque 0, tente logar com email e/ou senha errados, tente colocar uma quntidade inválida no carrinho (como um número negativo ou um número maior do que o disponível no estoque).

## Como rodar o projeto

### Compilar
```bash
javac -cp lib/junit-platform-console-standalone-6.1.0.jar -d bin (Get-ChildItem -Recurse -Filter *.java | Select-Object -ExpandProperty FullName)
```

### Executar
```bash
java -cp bin main.Main
```

### Rodar os testes
```bash
java -jar lib/junit-platform-console-standalone-6.1.0.jar execute -cp bin --scan-classpath
```

## Código do diagrama feito no mermaid:

```mermaid

classDiagram
    %% ==========================================
    %%                 INTERFACES
    %% ==========================================
    class ILojaOnline {
        <<interface>>
        +cadastrarCliente(Scanner scanner)
        +listarProdutos()
        +buscarProduto(String nome) Produto
        +criarPedido(Cliente cliente)
    }

    class IUsuario {
        <<interface>>
        +cadastrar()
        +login()
    }

    class IAdministrador {
        <<interface>>
        +cadastrarProduto(Produto produto)
        +gerenciarEstoque(Produto produto, int novaQuantidade)
    }

    class ICliente {
        <<interface>>
        +adicionarPedido(Pedido pedido)
        +exibirHistorico()
    }

    class IFazerCalculo {
        <<interface>>
        +calcularTotal() double
    }

    class IPagamento {
        <<interface>>
        +processarPagamento()
    }

    class IProduto {
        <<interface>>
        +removerDoEstoque(int quantidadeComprada)
        +atualizarEstoque(int novaQuantidade)
    }

    class ICarrinho {
        <<interface>>
        +adicionarItem(ItemCarrinho item)
        +removerItem(ItemCarrinho item)
    }

    %% ==========================================
    %%             CLASSES ABSTRATAS
    %% ==========================================
    class Usuario {
        <<abstract>>
        -String id 
        -String nome
        -String email
        -String senha
        +Autenticar(String email, String senha) boolean
        +cadastrar()
        +login()
    }

    class Produto {
        <<abstract>>
        -String id
        -String nome 
        -double preco
        -int estoque
        +removerDoEstoque(int quantidadeComprada)
        +atualizarEstoque(int novaQuantidade)
    }
    
    %% ==========================================
    %%             CLASSES CONCRETAS
    %% ==========================================
    class LojaOnline {
        -List~Cliente~ clientes
        -List~Pedido~ pedidos
        -List~Produto~ produtos
        -String nome
        +cadastrarCliente(Scanner scanner)
        +listarProdutos()
        +buscarProduto(String nome) Produto
        +criarPedido(Cliente cliente)
    }

    class Cliente {
        -Carrinho carrinho
        -List~Pedido~ historicoPedidos
        -String endereco
        +adicionarPedido(Pedido pedido)
        +exibirHistorico()
        +atualizarDados()
        +cadastrar()
        +login()
    }

    class Administrador {
        +atualizarDados()
        +cadastrarProduto(Produto produto)
        +gerenciarEstoque(Produto produto, int novaQuantidade)
        +cadastrar()
        +login()
    }

    class Carrinho {
        -List~ItemCarrinho~ itens
        +adicionarItem(ItemCarrinho item)
        +removerItem(ItemCarrinho item)
        +calcularTotal() double
        +getItens() List~ItemCarrinho~
    }

    class ItemCarrinho {
        -Produto produto
        -int quantidade
    }

    class Pedido {
        -int idPedido
        -LocalDate data
        -String status 
        -Cliente cliente
        -List~ItemCarrinho~ itens
        +gerarPedido()
        +calcularTotal() double
    }

    class ItemPedido {
        -String produto
        -int quantidade
        -double precoUnitario
    }

    class Pagamento {
        -String id
        -String metodo
        -String status
        +processarPagamento()
    }

    %% ==========================================
    %%                 EXCEPTIONS
    %% ==========================================
    class ProdutoNaoEncontradoException {
        <<Exception>>
        +String mensagem
    }

    class LoginInvalidoException {
        <<Exception>>
        +String mensagem
    }

    class EstoqueInvalidoException {
        <<Exception>>
        +String mensagem
    }

    class QuantidadeInvalidaException {
        <<Exception>>
        +String mensagem
    }

    %% ==========================================
    %%     IMPLEMENTAÇÕES (Assinando Contratos)
    %% ==========================================
    ILojaOnline <|.. LojaOnline : implements
    IFazerCalculo <|.. Carrinho : implements
    IFazerCalculo <|.. Pedido : implements
    IPagamento <|.. Pagamento : implements
    IUsuario <|.. Usuario : implements
    ICliente <|.. Cliente : implements
    IAdministrador <|.. Administrador : implements
    IProduto <|.. Produto : implements
    ICarrinho <|.. Carrinho : implements

    %% ==========================================
    %%                  HERANÇA
    %% ==========================================
    IUsuario <|-- IAdministrador : extends
    Usuario <|-- Cliente : extends
    Usuario <|-- Administrador : extends

    %% ==========================================
    %%                ASSOCIAÇÕES
    %% ==========================================
    LojaOnline --> "*" Cliente : possui
    LojaOnline --> "*" Pedido : gerencia
    LojaOnline --> "*" Produto : cataloga
    Cliente --> "1" Carrinho : possui
    Cliente --> "*" Pedido : realiza
    Pedido --> "1" Cliente : pertence
    Carrinho --> "*" ItemCarrinho : contem
    ItemCarrinho --> "1" Produto : referencia
    Pedido --> "*" ItemCarrinho : contem
    Pedido --> "1" Pagamento : possui

    %% ==========================================
    %%     LANÇAMENTO DE EXCEÇÕES (THROWS)
    %% ==========================================
    Usuario ..> LoginInvalidoException : throws
    LojaOnline ..> ProdutoNaoEncontradoException : throws
    Administrador ..> EstoqueInvalidoException : throws
    Produto ..> QuantidadeInvalidaException : throws

