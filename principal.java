public class principal {
    public static void main(String[] args) {
        Produto p1 = new Produto(1, "Camiseta", 50.0, 10, 3);
        Produto p2 = new Produto(2, "Calça", 30.0, 5, 2);
        p1.exibirInfo();
        p2.exibirInfo();
        p1.vender(2);
        p1.aplicarDesconto(10);
        p1.repor(5);
        p1.vender(15);
        p1.vender(8);
    }
}

