package net.weg.topcar.model.exceptions;

public class PrecoInvalidoException extends Exception{
    public PrecoInvalidoException() {
        super("O preço precisa ser maior que zero!");
    }
}
