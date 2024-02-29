package Projeto.Usuarios;

import Projeto.Venda;
import java.util.ArrayList;

public abstract class Funcionario extends Usuario {
    private ArrayList<Venda> vendas = new ArrayList<>();
    private float salario;

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
    public float verPagamento() {
        float comissao = 0;

        for (Venda venda: vendas) {
            // pegar 1% da venda e somar
        }

        return (comissao + this.salario);
    }

    public Funcionario(String nome, String cpf, String senha, float salario) {
        super(nome, cpf, senha);
        this.salario = salario;
    }

    public abstract void venderVeiculo(String codigoVeiculo, String cpfCliente);
}
