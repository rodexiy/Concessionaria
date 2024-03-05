package Projeto;

import Projeto.Usuarios.*;
import Projeto.Veiculos.Caminhao;
import Projeto.Veiculos.Carro;
import Projeto.Veiculos.Moto;
import Projeto.Veiculos.Veiculo;

import javax.security.auth.kerberos.KerberosTicket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static Cliente cliente = new Cliente("Pedro", "123", "123", "123");
    private static Carro Focus = new Carro("Ford", "Focus", "ABC1234", "123456", true, "Disponível", 10000, 2022, 50000.0f);
    private static Vendedor vendedor = new Vendedor("Jefferson", "432", "123",3000f);
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

            System.out.println("0 - Sair");
        }



        System.out.println("Insira a sua ação: ");
        int acao = sc.nextInt();
        switch (acao) {
            case 0 -> sair();
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

                if (logado instanceof Gerente) {
                    switch (acao) {
                        case 9 -> cadastrarVeiculo();
                        case 10 -> removerVeiculo();
                        case 11 -> editarVeiculo();
                        case 12 -> cadastrarUsuario();
                        case 13 -> removerUsuario();
                        case 14 -> editarUsuario();
                        case 15 -> verVendedores();
                        case 16 -> verClientes();
                        case 17 -> verPagamentosDosVendedores();
                        case 18 -> verPagamentoDeUmVendedor();
                    }
                }
            }



        }

    }

    public static void sair() {
        logado = null;
    }

    public static void verPagamento() {
        System.out.println("Pagamento: "+ ((Funcionario) logado).verPagamento());
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
            System.out.println("Veiculo não existe!");
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

    public static Veiculo menuCadastrarVeiculo() {
        System.out.println("Qual tipo de veiculo deseja cadastrar:");
        System.out.println("""
                1 - Carro
                2 - Moto
                3 - Caminhão
                """);

        int tipoVeiculo = sc.nextInt();

        System.out.println("Informe a marca do veículo:");
        String marca = sc.nextLine();

        System.out.println("Informe o modelo do veículo:");
        String modelo = sc.nextLine();

        System.out.println("Informe a placa do veículo:");
        String placa = sc.nextLine();

        System.out.println("Informe o código do veículo:");
        String codigo = sc.nextLine();

        System.out.println("O veículo é novo? (true/false):");
        boolean novo = sc.nextBoolean();

        System.out.println("Informe o status do veículo: (Disponivel/Vendido)");
        String status = sc.nextLine();

        System.out.println("Informe a quilometragem do veículo:");
        int quilometragem = sc.nextInt();

        System.out.println("Informe o ano do veículo:");
        int ano = sc.nextInt();

        System.out.println("Informe o preço do veículo:");
        float preco = sc.nextFloat();

        Veiculo veiculoGenerico = null;

        switch (tipoVeiculo) {
            case 1:
                veiculoGenerico = new Carro(marca, modelo, placa, codigo, novo, status, quilometragem, ano, preco);
                break;
            case 2:
                veiculoGenerico = new Moto(marca, modelo, placa, codigo, novo, status, quilometragem, ano, preco);
                break;
            case 3:
                System.out.println("Informe o peso máximo do veículo:");
                int pesoMaximo = sc.nextInt();

                System.out.println("Informe o comprimento do veículo:");
                float comprimento = sc.nextInt();

                System.out.println("Informe a quantidade de rodas do veículo:");
                int quantidadeDeRodas = sc.nextInt();
                veiculoGenerico = new Caminhao(marca, modelo, placa, codigo, novo, status, quilometragem, ano, preco, pesoMaximo, comprimento, quantidadeDeRodas);
        }

        return veiculoGenerico;

    }

    public static void cadastrarVeiculo() {
        Veiculo veiculoGenerico = menuCadastrarVeiculo();

        if (veiculoGenerico != null) {
            Veiculo.addVeiculo(veiculoGenerico);
            System.out.println("O veiculo foi cadastrado com sucesso!");
        }else {
            System.out.println("Não foi possivel cadastrar o veiculo!");
        }
    }

    public static void editarUsuario() {
        System.out.println("Insira o cpf do usuario que deseja editar: ");
        String cpf = sc.next();
        Usuario usuario = Usuario.getUsuario(cpf);

        if (usuario == null) {
            System.out.println("Não existe nenhum usuário com esse cpf!");
            return;
        }

        ((Gerente) gerente).editarUmUsuario(usuario);
        System.out.println("Usuário editado!");
    }

    public static void removerVeiculo() {
        System.out.println("Insira o codigo do veiculo que deseja remover: ");
        String codigo = sc.next();

        Veiculo veiculo = Veiculo.getVeiculo(codigo);

        if (veiculo != null) {
            logado.addVeiculo(veiculo);
            System.out.println("veiculo removido!");
        }else{
            System.out.println("O veiculo não existe");
        }
    }

    public static void editarVeiculo() {
        Veiculo novoVeiculo = menuCadastrarVeiculo();

        if (novoVeiculo != null) {
            if (Veiculo.getVeiculo(novoVeiculo.getCodigo()) == null) {
                System.out.println("Não existe nenhum veiculo com esse código");
                return;
            }

            ((Gerente) logado).editarVeiculo(novoVeiculo);
            System.out.println("Veiculo editado!");
        }else {
            System.out.println("Veiculo nao existe");
        }
    }

    public static void cadastrarUsuario() {
        Usuario usuario = menuCadastrarUsuario();

        if (usuario != null) {
            ((Gerente) logado).cadastrarUsuario(usuario);
        }
    }

    public static Usuario menuCadastrarUsuario() {
        System.out.println("""
                Que tipo de usuario deseja cadastrar/editar:
                1 - Cliente:
                2 - Vendedor:
                """);

        Usuario usuario = null;

        int tipoUsuario = sc.nextInt();

        System.out.println("Insira o nome do usuario: ");
        String nome = sc.next();

        System.out.println("Insira o cpf do usuario: ");
        String cpf = sc.next();

        System.out.println("Insira a senha: ");
        String senha = sc.next();

        switch (tipoUsuario) {
            case 1:
                System.out.println("Insira a CNH do usuario: ");
                String cnh = sc.next();
                usuario = new Cliente(nome, cpf, senha, cnh);
                break;
            case 2:
                System.out.println("Insira o salario do usuario: ");
                float salario = sc.nextFloat();
                usuario = new Vendedor(nome, cpf, senha, salario);
        }

        return usuario;
    }

    public static void verPagamentosDosVendedores() {
        System.out.println("Pagamento: "+ ((Gerente) gerente).verPagamentos());
    }

    public static void removerUsuario() {
        System.out.println("Insira o cpf do usuario que deseja remover: ");
        String cpf = sc.next();

        boolean callback = ((Gerente) logado).removerUsuario(cpf);

        if (callback) {
            System.out.println("Usuario removido!");
        }else {
            System.out.println("Não foi possivel remover o usuário!");
        }
    }

    public static void verVendedores() {
        for (Vendedor vendedor: ((Gerente) logado).verVendedores()) {
            System.out.println(vendedor.toString());
        }
    }

    public static void verClientes() {
        for (Cliente cliente: ((Gerente) logado).verClientes()) {
            System.out.println(cliente.toString());
        }
    }

    public static void verPagamentoDeUmVendedor() {
        System.out.println("Insira o cpf do vendedor: ");
        String cpf = sc.next();

        Usuario vendedor = Usuario.getUsuario(cpf);

        if (vendedor == null) {
            System.out.println("Vendedor não existe!");
            return;
        }
        if (!(vendedor instanceof  Vendedor)) {
            System.out.println("Usuário não é um vendedor!");
            return;
        }

        System.out.println("Pagamento: "+ ((Vendedor) vendedor).verPagamento());
    }
}
