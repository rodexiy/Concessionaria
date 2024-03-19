package net.weg.topcar.dao;

import net.weg.topcar.model.veiculos.Veiculo;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;

import java.util.Collections;
import java.util.List;

public class BancoAutomoveis
    implements IBanco<Veiculo, String> {
    private List<Veiculo> listaAutomoveis;

    public List<Veiculo> buscarTodos() {
        return Collections.unmodifiableList(
                listaAutomoveis);
    }

    public Veiculo buscarUm(String codigo)
            throws ObjetoNaoEncontradoException {
        for (Veiculo Veiculo : listaAutomoveis) {
            if (Veiculo.getCodigo().equals(codigo)) {
                return Veiculo;
            }
        }
        throw new ObjetoNaoEncontradoException(codigo);
    }

    public void adicionar(Veiculo Veiculo) {
        listaAutomoveis.add(Veiculo);
    }

    public void remover(String codigo)
            throws ObjetoNaoEncontradoException {
        Veiculo Veiculo = buscarUm(codigo);
        listaAutomoveis.remove(Veiculo);
    }

    public void alterar(String cpf,
                        Veiculo novoCliente)
            throws ObjetoNaoEncontradoException {
        Veiculo Veiculo = buscarUm(cpf);
        listaAutomoveis.set(
                listaAutomoveis.indexOf(Veiculo),
                novoCliente);
    }

}
