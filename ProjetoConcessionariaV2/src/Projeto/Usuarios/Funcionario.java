package Projeto.Usuarios;

import Projeto.Venda;
import java.util.ArrayList;

public abstract class Funcionario extends Usuario {
    protected ArrayList<Venda> vendas = new ArrayList<>();
    protected float salario;

    // faltou ser Static
    public static Usuario procurarCliente(String cpf) {
        for (Usuario usuario: Usuario.getUsuarios()) {
            if (usuario instanceof Cliente && usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }

        return null;
    }

    public void addVenda(Venda venda) {
        this.vendas.add(venda);
    }

    //trocar de int para float ou Double
    public abstract float verPagamento();

    public Funcionario(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha);
        this.salario = salario;
    }

    public abstract void venderVeiculo(String codigoVeiculo, String cpfCliente);
}
