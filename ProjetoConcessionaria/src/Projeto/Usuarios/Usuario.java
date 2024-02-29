package Projeto.Usuarios;

import Projeto.Veiculos.Veiculo;

import java.util.ArrayList;

public abstract class Usuario {
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    ArrayList<Veiculo> meusVeiculos = new ArrayList<>();
    private String nome;
    private String cpf;


    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public ArrayList<Veiculo> verMeusVeiculos() {
        return this.meusVeiculos;
    }

    // faltou editarUsuario
    public static void editarUsuario(Usuario novoUsuario) {
        for (Usuario usuarioAntigo: usuarios) {
            if (usuarioAntigo.cpf.equals(novoUsuario.cpf)) {
                usuarios.set(usuarios.indexOf(usuarioAntigo), novoUsuario);
            }
        }
    }

public static Usuario login(String cpf, String senha) {
    for (Usuario user: usuarios) {
        if (user.senha.equals(senha)) {
            return user;
        }
    }
    return null;
}



}
