package net.weg.topcar.model.exceptions;

public class OpcaoInvalidaException extends Exception {
    public OpcaoInvalidaException(int acao) {
        super("A opcao "+ acao + " é invalida!");
    }
}
