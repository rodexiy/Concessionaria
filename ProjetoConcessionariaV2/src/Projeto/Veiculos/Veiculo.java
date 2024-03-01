package Projeto.Veiculos;

import java.lang.reflect.Array;
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

    //faltou getVeiculo
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

        return null;
    }

    public static void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    //faltou
    public static List<Veiculo> getVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }

    //faltou editarVeiculo
    public static void editarVeiculo(Veiculo novoVeiculo) {
        for (Veiculo veiculoAntigo: veiculos) {
            if (veiculoAntigo.codigo.equals(novoVeiculo.codigo)) {
                veiculos.set(veiculos.indexOf(veiculoAntigo), novoVeiculo);
            }
        }
    }

    //faltou setStatus


    public void setStatus(String status) {
        this.status = status;
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

    public static List<Veiculo> verVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }

    //faltou pegar informações do estoque
    public String getInformacoesParaListarEstoque() {
        return  this.codigo + ": "+ this.marca + " " + this.modelo + " " + this.ano ;
    }

    //faltou toString
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
