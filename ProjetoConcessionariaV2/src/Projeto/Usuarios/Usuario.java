package Projeto.Usuarios;

import Projeto.Exceptions.SenhaIncorretaException;
import Projeto.Exceptions.UsuarioExistenteException;
import Projeto.Exceptions.UsuarioNaoEncontradoException;
import Projeto.Veiculos.Veiculo;

import java.util.*;

public abstract class Usuario {
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
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

    public static List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    public String menuFuncionario() {
        return """
               5 - Ver meus veiculos
               """;
    }

    public boolean usuarioExiste(String cpf) {
        for (Usuario usuario: usuarios) {
            if (usuario.cpf.equals(cpf)) {
                return true;
            }
        }

        return false;
    }

    public void addUsuario() throws UsuarioExistenteException  {
        if (usuarioExiste(this.cpf)) {
            throw new UsuarioExistenteException(this.cpf);
        }
        usuarios.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cpf, usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public static Usuario getUsuario(String cpf) {
        for (Usuario usuario: usuarios) {
            if (usuario.cpf.equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "meusVeiculos=" + meusVeiculos +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public List<Veiculo> verMeusVeiculos() {
        return Collections.unmodifiableList(this.meusVeiculos);
    }

    public static void editarUsuario(Usuario novoUsuario) {
        for (Usuario usuarioAntigo: usuarios) {
            if (usuarioAntigo.equals(novoUsuario)) {
                usuarios.set(usuarios.indexOf(usuarioAntigo), novoUsuario);
                break;
            }
        }
    }

    public void remUsuario() {
        usuarios.remove(this);
    }

    public static Usuario login(String cpf, String senha) throws UsuarioNaoEncontradoException {
        System.out.println(usuarios.toString());
        for (Usuario user: usuarios) {
            if (user.cpf.equals(cpf)) {
                if (!user.senha.equals(senha)) {
                    throw new SenhaIncorretaException();
                }

                return user;
            }
        }

        throw new UsuarioNaoEncontradoException(cpf);
    }

    public String getSenha() {
        return senha;
    }

    public static List<Vendedor> getVendedores() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            if (usuario instanceof Vendedor) {
                vendedores.add((Vendedor) usuario);
            }
        }

        return Collections.unmodifiableList(vendedores);
    }

    public static List<Cliente> getClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            if (usuario instanceof Cliente) {
                clientes.add((Cliente) usuario);
            }
        }

        return Collections.unmodifiableList(clientes);
    }

}
