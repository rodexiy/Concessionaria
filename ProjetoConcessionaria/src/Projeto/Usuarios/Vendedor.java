package Projeto.Usuarios;

import Projeto.Veiculos.Veiculo;
import Projeto.Venda;

public class Vendedor extends Funcionario {
    @Override
    public void venderVeiculo(String codigoVeiculo, String cpfCliente) {
        Usuario cliente = Funcionario.procurarCliente(cpfCliente);

        Veiculo veiculo = Veiculo.getVeiculo(codigoVeiculo);
        Venda venda = new Venda(this.getCpf(), cpfCliente, codigoVeiculo);
        addVenda(venda);
        cliente.addVeiculo(veiculo);
    }

    public Vendedor(String nome, String cpf, String senha , float salario) {
        super(nome, cpf, senha, salario);
    }
}
