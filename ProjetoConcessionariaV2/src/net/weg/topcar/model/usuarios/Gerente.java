package net.weg.topcar.model.usuarios;

import net.weg.topcar.Venda;
import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.exceptions.PrecoInvalidoException;
import net.weg.topcar.model.exceptions.ClienteExistenteException;
import net.weg.topcar.model.exceptions.VeiculoNaoEncontradoException;
import net.weg.topcar.model.veiculos.Veiculo;


import java.util.List;

public class Gerente extends Vendedor implements IGerente {
    public Gerente(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha, salario);
    }

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
                19 - Alterar preço de um veiculo
                """;
    }

    public void alterarPreco(String codigo, float novoPreco) {
        try {
            Veiculo veiculo = Veiculo.getVeiculo(codigo);
            veiculo.setPreco(novoPreco);
        }catch (VeiculoNaoEncontradoException exception) {
            System.err.println(exception);
        }catch (PrecoInvalidoException exception) {
            System.err.println(exception);
        }
    }

    public String removerVeiculo(String codigo) {
        try{
            Veiculo veiculo = Veiculo.getVeiculo(codigo);

            if (veiculo != null) {
                veiculo.remVeiculo();
                return "Veiculo removido!";
            }

        }catch (VeiculoNaoEncontradoException exception) {
            System.err.println(exception);
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
        for (Cliente cliente: getClientes()) {
            if (cliente instanceof Vendedor) {
                totalPagamento += ((Vendedor) cliente).verPagamento();
            }
        }

        return totalPagamento;
    }

    public String removerCliente(String cpf) {
        Cliente cliente = getCliente(cpf);

        if (cliente == null) {
            return "Cliente não existe!";
        }

        if (this.getCpf().equals(cpf)) {
            return "Você não pode remover a si mesmo!";
        }

        cliente.remCliente();
        return "Cliente removido!";
    }

    public Float verPagamentoDeUmVendedor(String cpf) {
        for (Cliente cliente: getClientes()) {
            if (cliente.getCpf().equals(cpf) && cliente instanceof Vendedor) {
                return ((Vendedor) cliente).verPagamento();
            }
        }
        
        return null;
    }

    public void cadastrarCliente(Cliente cliente) {
        try {
            cliente.addCliente();
        }catch (ClienteExistenteException exception) {
            System.err.println(exception);
        }
    }

    public void editarUmCliente(String cpf, Cliente novoCliente, IBanco<Cliente, String> banco) {
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

    @Override
    public List<Veiculo> verVeiculos(String codigo, IBanco<Veiculo, String> banco) {
        return null;
    }

    @Override
    public List<Veiculo> verMeusVeiculos(String codigo, IBanco<Veiculo, String> banco) {
        return null;
    }

    @Override
    public Veiculo verVeiculo(String codigo) {
        return null;
    }

    @Override
    public void venderVeiculo(Veiculo veiculo, Cliente cliente) {

    }

    @Override
    public Cliente buscarCliente(String cpf) {
        return null;
    }

    @Override
    public float verPagamento() {
        return 0;
    }
}
