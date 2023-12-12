package entities;

public class ContaBancaria {
    protected String tipoConta;
    protected String titular;
    protected double saldo;
    protected double limiteCredito;
    private double taxaRendimento;

    public ContaBancaria(String tipoConta, String titular) {
        this.tipoConta = tipoConta;
        this.titular = titular;
        this.saldo = 0;
        this.limiteCredito = 0;
        this.taxaRendimento = 1.5;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public boolean sacar(double valor) {
        if (saldo - valor >= -limiteCredito) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    public void solicitarEmprestimo(double valor) {
        if (valor <= limiteCredito) {
            saldo += valor;
            System.out.println("Empréstimo de R$" + valor + " concedido com sucesso.");
        } else {
            System.out.println("Valor de empréstimo superior ao limite de crédito.");
        }
    }

    public void aplicarRendimento() {
        double rendimento = saldo * (taxaRendimento / 100);
        saldo += rendimento;
        System.out.println("Rendimento aplicado: R$" + rendimento);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}
