package Projeto.Usuarios;

import Projeto.Exceptions.UsuarioNaoEncontradoException;

import java.util.ArrayList;

public interface IBanco<T, ID> {
    void alterar(ID cpf, T novo) throws UsuarioNaoEncontradoException;
    ArrayList<T> buscarTodos();
    void remover(T novo);
    void remover(ID id);
    T buscarTodos(ID id) throws UsuarioNaoEncontradoException;
    void adicionar(T novo);
}
