package Projeto;

public class Venda {
    String cpfVendedor;
    String cpfCliente;
    String codigo;

    // faltou construtor
    public Venda(String cpfVendedor, String cpfCliente, String codigo) {
        this.cpfVendedor = cpfVendedor;
        this.cpfCliente = cpfCliente;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getCpfVendedor() {
        return cpfVendedor;
    }
}
