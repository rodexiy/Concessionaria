package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.veiculos.Veiculo;

import java.util.List;

public interface ICliente {
    List<Veiculo> verVeiculos(String codigo, IBanco<Veiculo, String> banco);
    List<Veiculo> verMeusVeiculos(String codigo, IBanco<Veiculo, String> banco);
    Veiculo verVeiculo(String codigo);
}
