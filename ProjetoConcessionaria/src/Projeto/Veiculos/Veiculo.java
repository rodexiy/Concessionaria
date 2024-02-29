package Projeto.Veiculos;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Veiculo {
    static ArrayList<Veiculo> veiculos = new ArrayList<>();
    private String marca;
    private String modelo;
    private String placa;
    private String codigo;
    private boolean novo;
    private String status;
    private int quilometragem;
    private int ano;
    private float preco;


    public static String verVeiculo(String codigo) {
        Veiculo veiculo = getVeiculo(codigo);

        if (veiculo != null) {
            return veiculo.toString();
        }

        return null;
    }

    public static void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public boolean isVendido() {
        return status.equals("Vendido");
    }

    public static void remVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public static ArrayList<Veiculo> verVeiculos() {
        return veiculos;
    }

    public Veiculo(String marca, String modelo, String placa, String codigo, boolean novo, String status, int quilometragem, int ano, float preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.codigo = codigo;
        this.novo = novo;
        this.status = status;
        this.quilometragem = quilometragem;
        this.ano = ano;
        this.preco = preco;
    }
}
