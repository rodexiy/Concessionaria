package Projeto.Usuarios;

import Projeto.Exceptions.UsuarioNaoEncontradoException;
import Projeto.Exceptions.VeiculoExistenteException;
import Projeto.Exceptions.VeiculoNaoEncontradoException;
import Projeto.Veiculos.Veiculo;

import java.util.ArrayList;

public class BancoVeiculos implements IBanco<Veiculo, String>{
    private static ArrayList<Veiculo> listaVeiculos;

    public void alterar(String cpf, Veiculo novo) throws VeiculoNaoEncontradoException {
        Veiculo veiculo = buscar(cpf);
        listaVeiculos.set(listaVeiculos.indexOf(veiculo), novo);
    }

    public ArrayList<Veiculo> buscarTodos() {
        return listaVeiculos;
    }

    public void remover(Usuario usuario) {
        listaVeiculos.remove(usuario);
    }
    public Veiculo buscar(String codigo) throws VeiculoNaoEncontradoException {
        for (Veiculo novo: listaVeiculos) {
            if (novo.getCodigo().equals(codigo)) {
                return novo;
            }
        }

        throw new VeiculoNaoEncontradoException(codigo);
    }

    public void remover(String codigo) throws VeiculoNaoEncontradoException {
        listaVeiculos.remove(buscar(codigo));
    }


    public void adicionar(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }

}
