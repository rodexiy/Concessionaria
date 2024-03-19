package net.weg.topcar.model.exceptions;

public class AcessoNegadoException extends Exception {
    public AcessoNegadoException() {
        super("Você não possui o nível de acesso necessário para essa função!");
    }
}
