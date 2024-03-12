package Projeto.Usuarios;

import Projeto.Veiculos.Veiculo;

import java.util.List;

public class Gerente extends Funcionario{

    public Gerente(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha, salario);
    }

    @Override
    public String menuFuncionario() {
        return super.menuFuncionario() +
                """
                9 - Cadastrar veiculo
                10 - Remover veiculo
                11 - Editar veiculo
                12 - Adicionar Cliente/Vendedor
                13 - Remover Cliente/Vendedor
                14 - Editar Cliente/Vendedor
                15 - Ver vendedores
                16 - Ver clientes
                17 - Ver pagamento dos vendedores
                18 - Ver pagamento de um vendedor
                """;
    }

    public void alterarPreco(String codigo, float novoPreco) {
        Veiculo veiculo = Veiculo.getVeiculo(codigo);

        if (veiculo != null) {
            veiculo.setPreco(novoPreco);
        }
    }

    public String removerVeiculo(String codigo) {
        Veiculo veiculo = Veiculo.getVeiculo(codigo);

        if (veiculo != null) {
            veiculo.remVeiculo();
            return "Veiculo removido!";
        }

        return "Veiculo não existe!";
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculo.addVeiculo();
    }

    @Override
    protected double valorComissao() {
        return 0.02;
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

    public String removerUsuario(String cpf) {
        Usuario usuario = Usuario.getUsuario(cpf);

        if (usuario == null) {
            return "Usuario não existe!";
        }

        if (this.getCpf().equals(cpf)) {
            return "Você não pode remover a si mesmo!";
        }

        usuario.remUsuario();
        return "Usuario removido!";
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
        usuario.addUsuario();
    }

    public void editarUmUsuario(Usuario novoUsuario) {
        Usuario.editarUsuario(novoUsuario);
    }

    public void editarVeiculo(Veiculo novoVeiculo) {
        Veiculo.editarVeiculo(novoVeiculo);
    }

    public List<Vendedor> verVendedores() {
        return getVendedores();
    }

    public List<Cliente> verClientes() {
        return getClientes();
    }

}
