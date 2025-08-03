package main.java.dio.banco;

import lombok.Getter;
import lombok.ToString;
import main.java.dio.conta.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Getter
@ToString
public class Banco {
    private final String nome;
    private final List<Conta> contaList;

    public Banco(String nome) {
        this.nome = nome;
        this.contaList = new ArrayList<>();
    }

    public Conta findContaByNumeroConta(int numeroConta) {
       return contaList.stream().filter(i -> i.getNumero() == numeroConta).findFirst().orElseThrow(() -> new NoSuchElementException("Conta não encontrada"));
    }

    public List<Conta> findContaByCPF(String cpfCliente) {
        return contaList.stream().filter(i -> Objects.equals(i.getCliente().getCpf(), cpfCliente)).toList();
    }

    public boolean login(String cpf, String senha) {
        return contaList.stream().anyMatch(i -> i.getCliente().getCpf().equals(cpf) && i.getCliente().getSenha().equals(senha));
    }

    public void criandoConta(Conta conta) {
        contaList.add(conta);
        System.out.println("Conta criada com sucesso!");
    }
}
