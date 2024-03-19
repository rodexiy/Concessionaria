package net.weg.topcar.model.exceptions;

public class VeiculoNaoEncontradoException extends Exception {
    public VeiculoNaoEncontradoException(String codigo) {
        super("O veiculo de código " + codigo + " não foi encontrado!");
    }
}
