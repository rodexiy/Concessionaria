package Projeto.Exceptions;

public class PrecoInvalidoException extends Exception{
    public PrecoInvalidoException() {
        super("O preço precisa ser maior que zero!");
    }
}
