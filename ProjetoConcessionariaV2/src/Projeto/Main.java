package Projeto;

import Projeto.Usuarios.*;
import Projeto.Veiculos.Carro;
import Projeto.Veiculos.Veiculo;

import javax.security.auth.kerberos.KerberosTicket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static Cliente cliente = new Cliente("Pedro", "123", "123", "123");
    private static Carro Focus = new Carro("Ford", "Focus", "ABC1234", "123456", true, "Disponível", 10000, 2022, 50000.0f);
    private static Vendedor vendedor = new Vendedor("Jefferson", "312", "123",3000f);
    private static Gerente gerente = new Gerente("Henrique", "321",  "123", 7600f);
    private static Scanner sc = new Scanner(System.in);
    private static Usuario logado = null;

    public static void main(String[] args) {
        Usuario.addUsuario(cliente);
        Usuario.addUsuario(vendedor);
        Usuario.addUsuario(gerente);
        gerente.cadastrarVeiculo(Focus);

        do {
            menu();
        }while(true);

    }

    public static void menu() {
        System.out.println("""
                1 - Login
                2 - Cadastro
                3 - Ver estoque
                4 - Ver detalhes de um veiculo
                """);


        if (logado != null) {
            System.out.println("5 - Ver meus veiculos");
            if (logado instanceof Funcionario) {
                System.out.println("""
                        6 - Vender veiculo
                        7 - Procurar cliente
                        8 - Ver Pagamento
                        """);

                if (logado instanceof Gerente) {
                    System.out.println("""
                            9 - Cadastrar veiculo
                            10 - Remover veiculo
                            11 - Editar veiculo
                            12 - Adicionar Cliente/Vendedor
                            13 - Remover Cliente/Vendedor
                            14 - Editar Cliente/Vendedor
                            15 - Ver vendedores
                            16 - Ver clientes
                            17 - Ver pagamento dos vendedores
                            18 - Ver pagamento de um vendedor
                            """);
                }
            }
        }

        System.out.println("Insira a sua ação: ");
        int acao = sc.nextInt();
        switch (acao) {
            case 1 -> login();
            case 2 -> cadastroDeCliente();
            case 3 -> verEstoque();
            case 4 -> verDetalhesDeUmVeiculo();
        }

        if (logado != null) {
            if (acao == 5) {
                verMeusVeiculos();
            }

            if (logado instanceof Funcionario) {
                switch (acao) {
                    case 6 -> venderUmVeiculo();
                    case 7 -> procurarCliente();
                    case 8 -> verPagamento();

                }
            }


        }

    }

    public static void verPagamento() {

    }

    public static void procurarCliente() {
        System.out.println("Insira o cpf do cliente: ");
        String cpf = sc.next();

        Usuario cliente = Usuario.getUsuario(cpf);

        if (!(cliente instanceof Cliente)){
            System.out.println("Cliente não existe");
            return;
        }

        System.out.println(cliente.toString());
    }

    public static void venderUmVeiculo() {
        System.out.println("Insira o codigo do veiculo: ");
        String codigo = sc.next();
        Veiculo veiculo = Veiculo.getVeiculo(codigo);
        if (veiculo == null) {
            System.out.println("Veiculo não existe");
            return;
        }

        System.out.println("Insira o cpf do cliente: ");
        String cpf = sc.next();

        Usuario cliente = Usuario.getUsuario(cpf);
        if (cliente == null) {
            System.out.println("Usuario nao existe");
            return;
        }else{
            if (!(cliente instanceof Cliente)) {
                return;
            }
        }

        Venda venda = new Venda(logado.getCpf(), cpf, codigo);

        ((Funcionario) logado).addVenda(venda);
        veiculo.setStatus("Vendido");
        cliente.addVeiculo(veiculo);
    }

    public static void verMeusVeiculos() {
        for (Veiculo veiculo: logado.verMeusVeiculos()) {
            System.out.println(veiculo.toString());
        }
    }
    public static void verDetalhesDeUmVeiculo() {
        System.out.println("Insira o codigo do veiculo: ");
        String codigo = sc.next();
        Veiculo veiculo = Veiculo.getVeiculo(codigo);

        if (veiculo == null) {
            return;
        }

        System.out.println(veiculo.toString());
    }

    public static void verEstoque() {
        for (Veiculo veiculo: Veiculo.getVeiculos()) {
            System.out.println(veiculo.getInformacoesParaListarEstoque());
        }
    }

    public static void cadastroDeCliente() {
        System.out.println("Insira o nome: ");
        String nome = sc.next();
        System.out.println("Insira a senha: ");
        String senha = sc.next();
        System.out.println("Insira o CPF: ");
        String cpf = sc.next();
        System.out.println("Insira a CNH: ");
        String cnh = sc.next();


        Cliente cliente = new Cliente(nome, cpf, senha, cnh);
        Usuario.addUsuario(cliente);
    }
    public static void login() {
        System.out.println("Insira o cpf: ");
        String cpf = sc.next();
        System.out.println("Insira a senha: ");
        String senha = sc.next();
        logado = Usuario.login(cpf, senha);
    }
}
