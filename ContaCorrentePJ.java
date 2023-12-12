package entities;

class ContaCorrentePJ extends ContaBancaria {
    public ContaCorrentePJ(String titular) {
        super("2", titular);
        this.limiteCredito = 5000;
    }

    @Override
    public void solicitarEmprestimo(double valor) {
        if (valor <= limiteCredito) {
            saldo += valor;
            System.out.println("Empréstimo de R$" + valor + " concedido com sucesso.");
        } else {
            System.out.println("Valor de empréstimo superior ao limite de crédito.");
        }
    }
}
