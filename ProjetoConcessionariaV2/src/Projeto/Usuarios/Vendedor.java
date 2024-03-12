package Projeto.Usuarios;

public class Vendedor extends Funcionario {
    @Override
    protected double valorComissao() {
        return 0.01;
    }

    public Vendedor(String nome, String cpf, String senha , float salario) {
        super(nome, cpf, senha, salario);
    }
}
