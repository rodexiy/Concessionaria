package Projeto;

public class Venda {
    private String cpfVendedor;
    private String cpfCliente;
    private String codigo;

    public Venda(String cpfVendedor, String cpfCliente, String codigo) {
        this.cpfVendedor = cpfVendedor;
        this.cpfCliente = cpfCliente;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
