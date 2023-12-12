package entities;
import java.util.Scanner;

public class Appbanco {
    private ContaBancaria conta;

    public Appbanco() {
        conta = null;
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarConta(scanner);
                    break;
                case 2:
                    sacar(scanner);
                    break;
                case 3:
                    depositar(scanner);
                    break;
                case 4:
                    solicitarEmprestimo(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n----- Menu -----");
        System.out.println("1. Cadastrar conta");
        System.out.println("2. Sacar");
        System.out.println("3. Depositar");
        System.out.println("4. Solicitar empréstimo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void cadastrarConta(Scanner scanner) {
        System.out.println("\n----- Cadastrar Conta -----");
        System.out.print("Tipo de conta\n"
        		+ "escolha uma opção"
        		+ "\n1 - PF"
        		+ " \n2 - PJ "
        		+ "\n3 - Poupança: ");
        String tipoConta = scanner.next();

        System.out.print("Nome do titular: ");
        String titular = scanner.next();

        System.out.print("Realizar depósito inicial (S/N): ");
        boolean depositoInicial = scanner.next().equalsIgnoreCase("S");

        switch (tipoConta.toUpperCase()) {
            case "1":
                conta = new ContaCorrentePF(titular);
                break;
            case "2":
                conta = new ContaCorrentePJ(titular);
                break;
            case "3":
                conta = new ContaPoupanca(titular);
                break;
            default:
                System.out.println("Tipo de conta inválido.");
        }

        if (conta != null) {
            if (depositoInicial) {
                System.out.print("Valor do depósito inicial: R$");
                double valorDeposito = scanner.nextDouble();
                conta.depositar(valorDeposito);
            }

            System.out.println("Conta cadastrada com sucesso.");
        }
    }

    private void sacar(Scanner scanner) {
        System.out.println("\n----- Sacar -----");
        if (conta != null) {
            System.out.print("Valor do saque: R$");
            double valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Nenhuma conta cadastrada.");
        }
    }

    private void depositar(Scanner scanner) {
        System.out.println("\n----- Depositar -----");
        if (conta != null) {
            System.out.print("Valor do depósito: R$");
            double valorDeposito = scanner.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("Nenhuma conta cadastrada.");
        }
    }

    private void solicitarEmprestimo(Scanner scanner) {
        System.out.println("\n----- Solicitar Empréstimo -----");
        if (conta != null) {
            System.out.print("Valor do empréstimo: R$");
            double valorEmprestimo = scanner.nextDouble();
            conta.solicitarEmprestimo(valorEmprestimo);
        } else {
            System.out.println("Nenhuma conta cadastrada.");
        }
    }

}
