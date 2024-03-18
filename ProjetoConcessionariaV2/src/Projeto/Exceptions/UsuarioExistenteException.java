package Projeto.Exceptions;

public class UsuarioExistenteException extends Exception {
    public UsuarioExistenteException(String cpf) {
        super("Já existe um usuário com o cpf "+ cpf +" cadastrado!");
    }
}
