package main.java.dio.conta;

import lombok.Getter;
import lombok.ToString;

import main.java.dio.cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public abstract class Conta implements InterfaceConta{
    private static final int AGENCIA_BANCO = 1;
    private static int SEQUENCIA_NUMERO = 1;

    private final List<String> extrato;
    protected int agencia;
    protected int numero;
    protected double saldo;
    private final Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_BANCO;
        this.numero = SEQUENCIA_NUMERO++;
        this.saldo = 0d;
        this.cliente = cliente;
        this.extrato = new ArrayList<>();
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        extrato.add("DEPOSITO REALIZADO +R$ " + valor);
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Você não possui saldo suficiente!");
            return;
        }
        this.saldo -= valor;
        extrato.add("SAQUE REALIZADO -R$ " + valor);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        extrato.add("TRANSFERINDO PARA AGENCIA: " + contaDestino.agencia + " NUMERO: " + contaDestino.numero + " -R$" + valor);
    }

    @Override
    public void extratoConta() {
        System.out.println("AGENCIA :" + agencia + " NUMERO: " + numero);
        this.extrato.forEach(System.out::println);
        System.out.println("SALDO ATUAL: R$ " + saldo);
    }
}
