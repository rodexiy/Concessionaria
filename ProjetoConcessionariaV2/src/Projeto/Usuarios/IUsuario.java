package Projeto.Usuarios;

import Projeto.Veiculos.Veiculo;

import java.util.List;

public interface IUsuario {
    List<Veiculo> verVeiculos();
    List<Veiculo> verMeusVeiculos();
    Veiculo verVeiculo(String codigo);
}
