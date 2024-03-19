package Projeto.Usuarios;

import Projeto.Exceptions.PrecoInvalidoException;
import Projeto.Exceptions.UsuarioExistenteException;
import Projeto.Exceptions.VeiculoNaoEncontradoException;
import Projeto.Veiculos.Veiculo;

import java.util.List;

public interface IGerente extends IFuncionario {
     void alterarPreco(String codigo, float novoPreco) throws PrecoInvalidoException;
     String removerVeiculo(String codigo);
     void cadastrarVeiculo(Veiculo veiculo);
     float verPagamentos();
     String removerUsuario(String cpf);
     Float verPagamentoDeUmVendedor(String cpf);
     void cadastrarUsuario(Usuario usuario);
     void editarUmUsuario(Usuario novoUsuario);
     void editarVeiculo(Veiculo novoVeiculo);
     List<Vendedor> verVendedores();
     List<Cliente> verClientes();
}
