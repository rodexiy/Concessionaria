package Projeto.Usuarios;

import Projeto.Exceptions.VeiculoNaoEncontradoException;
import Projeto.Veiculos.Veiculo;
import Projeto.Venda;
import java.util.ArrayList;

public abstract class Funcionario extends Usuario {
    protected ArrayList<Venda> vendas = new ArrayList<>();
    protected float salario;

    protected abstract double valorComissao();

    public String menuFuncionario() {
        return super.menuFuncionario() + """
               6 - Vender veiculo
               7 - Procurar cliente
               8 - Ver Pagamento
               """;
    }

    public String procurarCliente(String cpf) {
        for (Usuario usuario: Usuario.getUsuarios()) {
            if (usuario instanceof Cliente && usuario.getCpf().equals(cpf)) {
                return usuario.toString();
            }
        }

        return "Cliente não existe!";
    }

    public void addVenda(Venda venda) {
        this.vendas.add(venda);
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

    public Funcionario(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha);
        this.salario = salario;
    }

    public void venderVeiculo(String codigoVeiculo, Usuario cliente) {
        try {
            Veiculo veiculo = Veiculo.getVeiculo(codigoVeiculo);

            if (veiculo.isVendido()) {
                return;
            }
            Venda venda = new Venda(this.getCpf(), cliente.getCpf(), codigoVeiculo);
            addVenda(venda);
            veiculo.setStatus("Vendido");
            cliente.addVeiculo(veiculo);
        }catch (VeiculoNaoEncontradoException exception) {
            System.out.println(exception);
        }
    };
}
