package main.java.dio.conta;

import main.java.Main;
import main.java.dio.cliente.Cliente;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtratoConta() {
        System.out.println("====== EXTRATO CONTA POUPANCA ======");
        extratoConta();
    }

    public void simularRendimentoConta(int quantidadeDias) {
        double saldoRendimento = (saldo * 0.001 * quantidadeDias) + saldo;
        System.out.println("O saldo final será de R$ " + saldoRendimento);
    }

    @Override
    public void exibirMenu() {
        Main.menuContaPoupanca(this);
    }
}
