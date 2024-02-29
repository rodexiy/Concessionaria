package Projeto.Veiculos;

public class Caminhao extends Veiculo {
    private String pesoMaximo;
    private int comprimento;
    private int quantidadeDeRodas;

    public Caminhao(String marca, String modelo, String placa, String codigo, boolean novo, String status, int quilometragem, int ano, float preco, String pesoMaximo, int comprimento, int quantidadeDeRodas) {
        super(marca, modelo, placa, codigo, novo, status, quilometragem, ano, preco);
        this.pesoMaximo = pesoMaximo;
        this.comprimento = comprimento;
        this.quantidadeDeRodas = quantidadeDeRodas;
    }
}
