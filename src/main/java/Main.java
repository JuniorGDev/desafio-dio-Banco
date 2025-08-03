package main.java;

import main.java.dio.banco.Banco;
import main.java.dio.cliente.Cliente;
import main.java.dio.conta.Conta;
import main.java.dio.conta.ContaCorrente;
import main.java.dio.conta.ContaPoupanca;

import java.util.Scanner;

public class Main {
    public final static Scanner scanner = new Scanner(System.in);
    public static int opcaoMenuConta = -1;

    private static Banco banco;
    private static Conta contaSelecionada;
    private static int opcaoSelecionada = -1;

    public static void main(String[] args) {
        System.out.println("BEM VINDO AO BANCO DIGITAL");
        System.out.println("DIGITE O NOME DO BANCO");
        String nomeBanco = scanner.nextLine();
        banco = new Banco(nomeBanco);

        while (opcaoSelecionada != 0) {
            System.out.println("SELECIONE UMA OPÇÃO");
            System.out.println("1 - CRIAR CONTA");
            System.out.println("2 - ENTRAR NA CONTA");
            System.out.println("3 - LISTAR CONTAS");
            System.out.println("4 - ENCONTRAR CONTA POR CPF");
            System.out.println("5 - ENCONTRAR CONTA POR NUMERO");
            System.out.println("0 - SAIR");
            opcaoSelecionada = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoSelecionada) {
                case 1 -> criandoConta();
                case 2 -> {
                    System.out.println("DIGITE O CPF DO TITULAR DA CONTA");
                    String cpf = scanner.nextLine();
                    if (banco.findContaByCPF(cpf).isEmpty()) {
                        System.out.println("CONTA NÃO ENCONTRADA");
                    } else {
                        System.out.println("DIGITE SUA SENHA");
                        String senha = scanner.nextLine();
                        if (banco.login(cpf, senha)) {
                            if (banco.findContaByCPF(cpf).size() == 1) {
                                contaSelecionada = banco.findContaByCPF(cpf).get(0);
                            } else {
                                System.out.println("QUAL CONTA DESEJA SELECIONAR?");
                                for (int i = 0; i < banco.findContaByCPF(cpf).size(); i++) {
                                    System.out.println((i + 1) + " - " + banco.findContaByCPF(cpf).get(i).getNumero());
                                }
                                var opcao = scanner.nextInt();
                                scanner.nextLine();
                                contaSelecionada = banco.findContaByCPF(cpf).get(opcao - 1);
                            }
                            while (opcaoMenuConta != 0) {
                                contaSelecionada.exibirMenu();
                            }
                        } else {
                            System.out.println("CPF OU SENHA INCORRETOS");
                        }
                    }
                }
                case 3 -> System.out.println(banco.getContaList());
                case 4 -> {
                    System.out.println("DIGITE O CPF");
                    String cpf = scanner.nextLine();
                    System.out.println(banco.findContaByCPF(cpf));
                }
                case 5 -> {
                    System.out.println("DIGITE O NUMERO");
                    int numero = scanner.nextInt();
                    System.out.println(banco.findContaByNumeroConta(numero));
                }
                case 0 -> System.out.println("OBRIGADO POR USAR O BANCO DIGITAL " + banco.getNome());
                default -> System.out.println("OPÇÃO NÃO ENCONTRADA");
            }
        }
    }

    private static void criandoConta() {
        System.out.println("DIGITE O NOME DO CLIENTE");
        String nomeCliente = scanner.nextLine();
        System.out.println("DIGITE A IDADE DO CLIENTE");
        int idadeCliente = scanner.nextInt();
        scanner.nextLine();
        System.out.println("DIGITE O CPF DO CLIENTE");
        String cpfCliente = scanner.nextLine();
        System.out.println("DIGITE SUA SENHA");
        String senha = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente, idadeCliente, cpfCliente, senha);
        System.out.println("SELECIONE UMA CONTA");
        System.out.println("1 - CONTA CORRENTE");
        System.out.println("2 - CONTA POUPANCA");
        int opcaoConta = scanner.nextInt();
        scanner.nextLine();
        Conta conta;
        if (opcaoConta == 1) {
            conta = new ContaCorrente(cliente);
        } else {
            conta = new ContaPoupanca(cliente);
        }
        banco.criandoConta(conta);
    }

    private static double digiteUmValor() {
        double valor = -1;
        while (valor <= 0) {
            System.out.println("DIGITE UM VALOR MAIOR QUE ZERO:");
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
            } else {
                System.out.println("VALOR INVÁLIDO.");
                scanner.next();
            }
        }
        return valor;
    }

    public static void menuContaPoupanca(ContaPoupanca contaPoupanca) {
        System.out.println("SELECIONE UMA OPÇÃO");
        System.out.println("1 - DEPOSITAR");
        System.out.println("2 - SACAR");
        System.out.println("3 - EXTRATO");
        System.out.println("4 - SIMULAR RENDIMENTO");
        System.out.println("5 - TRANSFERIR");
        System.out.println("0 - SAIR");
        opcaoMenuConta = scanner.nextInt();
        scanner.nextLine();
        switch (opcaoMenuConta) {
            case 1 -> contaPoupanca.depositar(digiteUmValor());
            case 2 -> contaPoupanca.sacar(digiteUmValor());
            case 3 -> contaPoupanca.imprimirExtratoConta();
            case 4 -> {
                System.out.println("DIGITE A QUANTIDADE DE DIAS");
                contaPoupanca.simularRendimentoConta(scanner.nextInt());
            }
            case 5 -> {
                System.out.println("DIGITE O NUMERO DA CONTA");
                int cpfDestino = scanner.nextInt();
                Conta contaDestino = banco.findContaByNumeroConta(cpfDestino);
                contaPoupanca.transferir(digiteUmValor(), contaDestino);
                System.out.println("TRANSFERENCIA REALIZADA COM SUCESSO");
            }
        }
    }

    public static void menuContaCorrente(ContaCorrente contaCorrente) {
        System.out.println("SELECIONE UMA OPÇÃO");
        System.out.println("1 - DEPOSITAR");
        System.out.println("2 - SACAR");
        System.out.println("3 - EXTRATO");
        System.out.println("4 - TRANSFERIR");
        System.out.println("0 - SAIR");
        opcaoMenuConta = scanner.nextInt();
        scanner.nextLine();
        switch (opcaoMenuConta) {
            case 1 -> contaCorrente.depositar(digiteUmValor());
            case 2 -> contaCorrente.sacar(digiteUmValor());
            case 3 -> contaCorrente.imprimirExtratoConta();
            case 4 -> {
                System.out.println("DIGITE O CPF DO DESTINO");
                String cpfDestino = scanner.nextLine();
                Conta contaDestino = banco.findContaByCPF(cpfDestino).get(0);
                System.out.println("DIGITE O VALOR A SER TRANSFERIDO");
                contaCorrente.transferir(digiteUmValor(), contaDestino);
            }
        }
    }
}