package Projeto.Exceptions;

public class AcessoNegadoException extends Exception {
    public AcessoNegadoException() {
        super("Você não possui o nível de acesso necessário para essa função!");
    }
}
