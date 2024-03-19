package net.weg.topcar.model.usuarios;

import net.weg.topcar.model.veiculos.Veiculo;

public interface IVendedor extends ICliente {

    void venderVeiculo(Veiculo veiculo, Cliente cliente);
    Cliente buscarCliente(String cpf);
    float verPagamento();

}
