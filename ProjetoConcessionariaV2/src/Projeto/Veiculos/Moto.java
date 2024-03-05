package Projeto.Veiculos;

public class Moto extends Veiculo{
    public Moto(String marca, String modelo, String placa, String codigo, boolean novo, String status, int quilometragem, int ano, float preco) {
        super(marca, modelo, placa, codigo, novo, status, quilometragem, ano, preco);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
