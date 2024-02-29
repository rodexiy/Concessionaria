package Projeto.Usuarios;

public class Cliente extends Usuario {
    private String cnh;

    public Cliente(String nome, String cpf, String cnh) {
        super(nome, cpf);
        this.cnh = cnh;
    }

}
