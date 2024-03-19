package Projeto.Usuarios;

import Projeto.Exceptions.UsuarioNaoEncontradoException;

import java.util.ArrayList;

public class BancoUsuario {
    private static ArrayList<Usuario> listaUsuarios;

    public void alterar(String cpf, Usuario novoUsuario) throws UsuarioNaoEncontradoException {
        Usuario usuario = procurarUsuario(cpf);
        listaUsuarios.set(listaUsuarios.indexOf(usuario), novoUsuario);
    }

    public ArrayList<Usuario> buscarTodosUsuarios() {
        return listaUsuarios;
    }

    public void remover(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }
    public Usuario procurarUsuario(String cpf) throws UsuarioNaoEncontradoException {
        for (Usuario usuario: listaUsuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }

        throw new UsuarioNaoEncontradoException(cpf);
    }

    public void remover(String cpf) throws UsuarioNaoEncontradoException {
        listaUsuarios.remove(procurarUsuario(cpf));
    }


    public void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

}
