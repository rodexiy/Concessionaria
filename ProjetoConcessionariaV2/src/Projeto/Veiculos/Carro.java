package Projeto.Veiculos;

public class Carro extends Veiculo{
    public Carro(String marca, String modelo, String placa, String codigo, boolean novo, String status, int quilometragem, int ano, float preco) {
        super(marca, modelo, placa, codigo, novo, status, quilometragem, ano, preco);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
