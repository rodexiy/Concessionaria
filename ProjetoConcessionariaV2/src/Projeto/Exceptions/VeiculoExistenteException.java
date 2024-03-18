package Projeto.Exceptions;

public class VeiculoExistenteException extends Exception {
    public VeiculoExistenteException(String codigo) {
        super("Um veiculo com o código "+ codigo + " já foi cadastrado!");
    }
}
