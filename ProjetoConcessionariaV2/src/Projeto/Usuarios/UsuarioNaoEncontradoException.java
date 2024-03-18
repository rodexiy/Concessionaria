package Projeto.Usuarios;

public class UsuarioNaoEncontradoException extends Exception {
    public UsuarioNaoEncontradoException(String cpf) {
        super("O Usuário de CPF: "+ cpf +" não foi encontrado!");
    }
}
