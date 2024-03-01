package Projeto.Usuarios;

import Projeto.Veiculos.Veiculo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Usuario {
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    ArrayList<Veiculo> meusVeiculos = new ArrayList<>();
    private String nome;
    private String cpf;

    private String senha;
    // faltou addVeiculos
    // faltou senha
    // getUsuario
    // getCpf
    // addVeiculo

    public String getCpf() {
        return cpf;
    }

    public void addVeiculo(Veiculo veiculo) {
        meusVeiculos.add(veiculo);
    }

    public static List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
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

    // faltou editarUsuario
    public static void editarUsuario(Usuario novoUsuario) {
        for (Usuario usuarioAntigo: usuarios) {
            if (usuarioAntigo.cpf.equals(novoUsuario.cpf)) {
                usuarios.set(usuarios.indexOf(usuarioAntigo), novoUsuario);
            }
        }
    }

    public static void remUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }


public static Usuario login(String cpf, String senha) {
    for (Usuario user: usuarios) {
        if (user.cpf.equals(cpf) && user.senha.equals(senha)) {
            return user;
        }
    }

    return null;
}



}
