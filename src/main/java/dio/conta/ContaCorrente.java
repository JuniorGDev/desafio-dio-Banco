package main.java.dio.conta;

import main.java.Main;
import main.java.dio.cliente.Cliente;

public class ContaCorrente extends Conta{
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtratoConta() {
        System.out.println("====== EXTRATO CONTA CORRENTE ======");
        extratoConta();
    }

    @Override
    public void exibirMenu() {
        Main.menuContaCorrente(this);
    }
}
