package entities;

class ContaCorrentePF extends ContaBancaria {
    public ContaCorrentePF(String titular) {
        super("1", titular);
        this.limiteCredito = 1000;
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
