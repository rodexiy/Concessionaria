package net.weg.topcar.model.usuarios;

import net.weg.topcar.Venda;
import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.exceptions.VeiculoNaoEncontradoException;
import net.weg.topcar.model.veiculos.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Cliente implements IVendedor  {
    protected ArrayList<Venda> vendas = new ArrayList<>();
    protected float salario;


    @Override
    public void venderVeiculo(Veiculo veiculo, Cliente cliente) {

    }

    @Override
    public Cliente buscarCliente(String cpf) {
        return null;
    }

    public void addVenda(Venda venda) {
        vendas.add(venda);
    }

    public float verPagamento() {
        float comissao = 0;

        for (Venda venda: vendas) {
            try {
                Veiculo veiculo = Veiculo.getVeiculo(venda.getCodigo());

                if (veiculo != null) {
                    comissao += veiculo.getPreco() * valorComissao();
                }
            }catch (VeiculoNaoEncontradoException exception) {
                System.err.println(exception);
            }
        }

        return (comissao + this.salario);
    }

    public void venderVeiculo(String codigoVeiculo, Cliente cliente) {
        try {
            Veiculo veiculo = Veiculo.getVeiculo(codigoVeiculo);

            if (veiculo.isVendido()) {
                return;
            }
            Venda venda = new Venda(getCpf(), cliente.getCpf(), codigoVeiculo);
            addVenda(venda);
            veiculo.setStatus("Vendido");
            cliente.addVeiculo(veiculo);
        }catch (VeiculoNaoEncontradoException exception) {
            System.out.println(exception);
        }
    };

    public String procurarCliente(String cpf, IBanco<Cliente, String> banco) {
        for (Cliente cliente: banco.buscarTodos()) {
            if (cliente instanceof Cliente && cliente.getCpf().equals(cpf)) {
                return cliente.toString();
            }
        }

        return "Cliente não existe!";
    }

    protected double valorComissao() {
        return 0.01;
    }

    public Vendedor(String nome, String cpf, String senha , float salario) {
        super(nome, cpf, senha);
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
}
