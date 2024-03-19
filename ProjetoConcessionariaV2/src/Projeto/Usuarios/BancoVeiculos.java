package Projeto.Usuarios;

import Projeto.Exceptions.UsuarioNaoEncontradoException;
import Projeto.Veiculos.Veiculo;

import java.util.ArrayList;

public class BancoVeiculos implements IBanco<Usuario, String>{
    private static ArrayList<Veiculo> listaVeiculos;

    public void alterar(String cpf, Usuario novoUsuario) throws UsuarioNaoEncontradoException {
        Usuario usuario = procurarUsuario(cpf);
        listaVeiculos.set(listaVeiculos.indexOf(usuario), novoUsuario);
    }

    public ArrayList<Usuario> buscarTodosUsuarios() {
        return listaVeiculos;
    }

    public void remover(Usuario usuario) {
        listaVeiculos.remove(usuario);
    }
    public Usuario buscar(String cpf) throws UsuarioNaoEncontradoException {
        for (Usuario usuario: listaUsuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }

        throw new UsuarioNaoEncontradoException(cpf);
    }

    public void remover(String cpf) throws UsuarioNaoEncontradoException {
        listaVeiculos.remove(procurarUsuario(cpf));
    }


    public void adicionar(Usuario usuario) {
        listaVeiculos.add(usuario);
    }

}
