package Projeto.Usuarios;

import Projeto.Veiculos.Veiculo;
import Projeto.Venda;

public class Gerente extends Funcionario{

    public Gerente(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha, salario);
    }

    @Override
    public void venderVeiculo(String codigoVeiculo, String cpfCliente) {
        Usuario cliente = Funcionario.procurarCliente(cpfCliente);

        Venda venda = new Venda(this.getCpf(), cpfCliente, codigoVeiculo);
        addVenda(venda);
        //cliente.addVeiculo();
    }

    public void alterarPreco(String codigo, float novoPreco) {
        Veiculo veiculo = Veiculo.getVeiculo(codigo);

        if (veiculo != null) {
            veiculo.setPreco(novoPreco);
        }
    }

    public void removerVeiculo(String codigo) {
        Veiculo veiculo = Veiculo.getVeiculo(codigo);

        if (veiculo != null) {
            Veiculo.remVeiculo(veiculo);
        }
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        Veiculo.addVeiculo(veiculo);
    }

    @Override
    public float verPagamento() {
        float comissao = 0;

        for (Venda venda: vendas) {
            Veiculo veiculo = Veiculo.getVeiculo(venda.getCodigo());

            if (veiculo != null) {
                comissao += veiculo.getPreco() * 0.02;
            }
        }

        return (comissao + this.salario);
    }

    public float verPagamentos() {
        float totalPagamento = 0;
        for (Usuario usuario: getUsuarios()) {
            if (usuario instanceof Funcionario) {
                totalPagamento += ((Funcionario) usuario).verPagamento();
            }
        }

        return totalPagamento;
    }

    public boolean removerUsuario(String cpf) {
        Usuario usuario = Usuario.getUsuario(cpf);

        if (usuario == null) {
            return false;
        }

        if (this.getCpf().equals(cpf)) {
            return false;
        }

        remUsuario(usuario);
        return true;

    }

    public Float verPagamentoDeUmVendedor(String cpf) {
        for (Usuario usuario: getUsuarios()) {
            if (usuario.getCpf().equals(cpf) && usuario instanceof Funcionario) {
                return ((Funcionario) usuario).verPagamento();
            }
        }
        
        return null;
    }

    public void cadastrarUsuario(Usuario usuario) {
        addUsuario(usuario);
    }

    public void editarUmUsuario(Usuario novoUsuario) {
        Usuario.editarUsuario(novoUsuario);
    }

    public void editarVeiculo(Veiculo novoVeiculo) {
        for (Veiculo veiculo: Veiculo.getVeiculos()) {

        }
    }


}
