package Projeto.Exceptions;

public class UsuarioNaoEncontradoException extends Exception {
    public UsuarioNaoEncontradoException(String cpf) {
        super("O Usuário de CPF: "+ cpf +" não foi encontrado!");
    }
}
