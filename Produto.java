public class Produto {

    private int codigo;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private int estoqueMinimo;

    public Produto(int codigo, String nome, double preco, int quantidadeEstoque, int estoqueMinimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco; 
        this.quantidadeEstoque = quantidadeEstoque;
        this.estoqueMinimo = estoqueMinimo;
    }  
    
    public int getCodigo() {
        return codigo;
    }
    public double getpreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if (preco < 0) {
            System.out.println("O preço não pode ser negativo!");
        } else {
            this.preco = preco;
        }
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0) {
            System.out.println("A quantidade em estoque não pode ser negativa!");
        } else {
            this.quantidadeEstoque = quantidadeEstoque;
        }
    }
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < 0) {
            System.out.println("O estoque mínimo não pode ser negativo!");
        } else {
            this.estoqueMinimo = estoqueMinimo;
        }
    }
    public void vender(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("A quantidade a ser vendida deve ser maior que zero.");
        } else if (quantidade > quantidadeEstoque) {
            System.out.println("Estoque insuficiente para vender " + quantidade + " unidades de " + nome + ".");
        } else {
            quantidadeEstoque -= quantidade;
            System.out.println("Venda realizada: " + quantidade + " unidades de " + nome + " vendidas.");
            if (quantidadeEstoque < estoqueMinimo) {
                System.out.println("Atenção: Estoque de " + nome + " abaixo do mínimo. Repor estoque.");
            }
        }
    }
    public void repor(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("A quantidade a ser reposta deve ser maior que zero.");
        } else {
            quantidadeEstoque += quantidade;
            System.out.println("Reposição realizada: " + quantidade + " unidades de " + nome + " adicionadas ao estoque.");
        }
    }
    public void aplicarDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) {
            System.out.println("Percentual de desconto inválido. Deve estar entre 0 e 100.");
        } else {
            double desconto = (percentual / 100) * preco;
            preco -= desconto;
            System.out.println("Desconto aplicado: " + percentual + "%. Novo preço de " + nome + ": R$" + String.format("%.2f", preco));
        }
    }
    private boolean verificarEstoque() {
        return quantidadeEstoque < estoqueMinimo;
    }
    public void exibirInfo() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$" + String.format("%.2f", preco));
        System.out.println("Quantidade em Estoque: " + quantidadeEstoque);
        System.out.println("Estoque Mínimo: " + estoqueMinimo);
        if (verificarEstoque()) {
            System.out.println("Atenção: Estoque abaixo do mínimo!");
        }
    }
}