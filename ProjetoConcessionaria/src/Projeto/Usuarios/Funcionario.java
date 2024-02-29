package Projeto.Usuarios;

import Projeto.Venda;
import java.util.ArrayList;

public abstract class Funcionario extends Usuario {
    private ArrayList<Venda> vendas = new ArrayList<>();
    private float salario;

    public Usuario procurarCliente(String cpf) {
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

    public int verPagamento() {
        float comissao = 0;

        for (Venda venda: vendas) {
            // pegar 1% da venda e somar
        }

        return (comissao + this.salario);
    }

    public Funcionario(String nome, String cpf, float salario) {
        super(nome, cpf);
        this.salario = salario;
    }

    public abstract void venderVeiculo(String codigoVeiculo, String cpfCliente);
}
