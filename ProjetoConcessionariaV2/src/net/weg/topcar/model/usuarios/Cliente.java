package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.SenhaIncorretaException;
import net.weg.topcar.model.exceptions.ClienteExistenteException;
import net.weg.topcar.model.exceptions.ClienteNaoEncontradoException;
import net.weg.topcar.model.veiculos.Veiculo;


import java.util.*;

public class Cliente implements ICliente{

    static ArrayList<Cliente> cliente = new ArrayList<Cliente>();
    private ArrayList<Veiculo> meusVeiculos = new ArrayList<>();
    private String nome;
    private String cpf;
    private String senha;
    public String getCpf() {
        return cpf;
    }
    public void addVeiculo(Veiculo veiculo) {
        meusVeiculos.add(veiculo);
    }

    public String menuFuncionario() {
        return """
               5 - Ver meus veiculos
               """;
    }

    public boolean clienteExiste(String cpf) {
        for (Cliente cliente: cliente) {
            if (cliente.cpf.equals(cpf)) {
                return true;
            }
        }

        return false;
    }

    public void addCliente() throws ClienteExistenteException  {
        if (clienteExiste(this.cpf)) {
            throw new ClienteExistenteException(this.cpf);
        }
        cliente.add(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public static Cliente getCliente(String cpf) {
        for (Cliente cliente: cliente) {
            if (cliente.cpf.equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "meusVeiculos=" + meusVeiculos +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public Cliente(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    @Override
    public List<Veiculo> verVeiculos(String codigo, IBanco<Veiculo, String> banco) {
        return banco.buscarTodos();
    }

    @Override
    public List<Veiculo> verMeusVeiculos(String codigo, IBanco<Veiculo, String> banco) {
        return null;
    }

    @Override
    public Veiculo verVeiculo(String codigo) {
        return null;
    }

    public List<Veiculo> verMeusVeiculos() {
        return Collections.unmodifiableList(this.meusVeiculos);
    }

    public Veiculo verVeiculo(String codigo, IBanco<Veiculo, String> banco) throws ObjetoNaoEncontradoException {
        return banco.buscarUm(codigo);
    }

    public static void editarCliente(Cliente novoCliente) {
        for (Cliente usuarioAntigo: cliente) {
            if (usuarioAntigo.equals(novoCliente)) {
                cliente.set(cliente.indexOf(usuarioAntigo), novoCliente);
                break;
            }
        }
    }

    public void remCliente() {
        cliente.remove(this);
    }

    public static Cliente login(String cpf, String senha) throws ClienteNaoEncontradoException {
        System.out.println(cliente.toString());
        for (Cliente user: cliente) {
            if (user.cpf.equals(cpf)) {
                if (!user.senha.equals(senha)) {
                    throw new SenhaIncorretaException();
                }

                return user;
            }
        }

        throw new ClienteNaoEncontradoException(cpf);
    }

    public String getSenha() {
        return senha;
    }

    public static List<Vendedor> getVendedores() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        for (Cliente cliente: cliente) {
            if (cliente instanceof Vendedor) {
                vendedores.add((Vendedor) cliente);
            }
        }

        return Collections.unmodifiableList(vendedores);
    }

    public static List<Cliente> getClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (Cliente cliente: cliente) {
            if (cliente instanceof Cliente) {
                clientes.add((Cliente) cliente);
            }
        }

        return Collections.unmodifiableList(clientes);
    }

}
