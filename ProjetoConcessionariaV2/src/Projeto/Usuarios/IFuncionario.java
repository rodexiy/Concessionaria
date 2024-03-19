package Projeto.Usuarios;

import Projeto.Veiculos.Veiculo;

public interface IFuncionario extends IUsuario {
    void vender(Veiculo veiculo, Usuario usuario);
    Usuario buscarUsuario(String cpf);
    String verPagamento();

}
