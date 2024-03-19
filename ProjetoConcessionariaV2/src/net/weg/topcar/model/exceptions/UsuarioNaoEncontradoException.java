package net.weg.topcar.model.exceptions;

public class ClienteNaoEncontradoException extends Exception {
    public ClienteNaoEncontradoException(String cpf) {
        super("O Usuário de CPF: "+ cpf +" não foi encontrado!");
    }
}
