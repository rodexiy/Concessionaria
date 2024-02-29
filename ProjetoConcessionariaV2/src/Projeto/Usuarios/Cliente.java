package Projeto.Usuarios;

public class Cliente extends Usuario {
    private String cnh;

    public Cliente(String nome, String cpf, String senha, String cnh) {
        super(nome, cpf, senha);
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cnh='" + cnh + '\'' +
                '}';
    }
}
