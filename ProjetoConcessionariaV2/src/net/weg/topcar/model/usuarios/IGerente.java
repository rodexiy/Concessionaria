package net.weg.topcar.model.usuarios;

import net.weg.topcar.model.exceptions.PrecoInvalidoException;
import net.weg.topcar.model.veiculos.Veiculo;
import java.util.List;
import net.weg.topcar.model.usuarios.Vendedor;

public interface IGerente extends IVendedor {
     void alterarPreco(String codigo, float novoPreco) throws PrecoInvalidoException;
     String removerVeiculo(String codigo);
     void cadastrarVeiculo(Veiculo veiculo);
     float verPagamentos();
     String removerCliente(String cpf);
     Float verPagamentoDeUmVendedor(String cpf);
     void cadastrarCliente(Cliente cliente);
     void editarUmCliente(Cliente novoCliente);
     void editarVeiculo(Veiculo novoVeiculo);
     List<Vendedor> verVendedores();
     List<Cliente> verClientes();
}
