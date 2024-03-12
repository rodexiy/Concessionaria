package Projeto.Veiculos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static Veiculo getVeiculo(String codigo) {
        for (Veiculo veiculo: veiculos) {
            if (veiculo.codigo.equals(codigo)) {
                return veiculo;
            }
        }
        return null;
    }

    public static String verVeiculo(String codigo) {
        Veiculo veiculo = getVeiculo(codigo);

        if (veiculo != null) {
            return veiculo.toString();
        }

        return "Veiculo não existe!";
    }

    public void addVeiculo() {
        veiculos.add(this);
    }

    public static List<Veiculo> getVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }

    public static void editarVeiculo(Veiculo novoVeiculo) {
        for (Veiculo veiculoAntigo: veiculos) {
            if (veiculoAntigo.codigo.equals(novoVeiculo.codigo)) {
                veiculos.set(veiculos.indexOf(veiculoAntigo), novoVeiculo);
            }
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isVendido() {
        return status.equals("Vendido");
    }

    public void remVeiculo() {
        veiculos.remove(this);
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public static List<Veiculo> verVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }

    public String getInformacoesParaListarEstoque() {
        return  this.codigo + ": "+ this.marca + " " + this.modelo + " " + this.ano ;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", codigo='" + codigo + '\'' +
                ", novo=" + novo +
                ", status='" + status + '\'' +
                ", quilometragem=" + quilometragem +
                ", ano=" + ano +
                ", preco=" + preco +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public float getPreco() {
        return preco;
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
