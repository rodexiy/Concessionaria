package net.weg.topcar.model.exceptions;

public class ClienteExistenteException extends Exception {
    public ClienteExistenteException(String cpf) {
        super("Já existe um usuário com o cpf "+ cpf +" cadastrado!");
    }
}
