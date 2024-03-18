package Projeto;

import Projeto.Usuarios.*;
import Projeto.Veiculos.Caminhao;
import Projeto.Veiculos.Carro;
import Projeto.Veiculos.Moto;
import Projeto.Veiculos.Veiculo;
import java.util.Scanner;

public class Main {
    private static final Cliente cliente = new Cliente("Pedro", "123", "123", "123");
    private static final Carro Focus = new Carro("Ford", "Focus", "ABC1234", "123456", true, "Disponível", 10000, 2022, 50000.0f);
    private static final Vendedor vendedor = new Vendedor("Jefferson", "432", "123",3000f);
    private static final Gerente gerente = new Gerente("Henrique", "321",  "123", 7600f);
    private static final Scanner sc = new Scanner(System.in);
    private static Usuario logado = null;

    public static void main(String[] args) {
        cliente.addUsuario();
        vendedor.addUsuario();
        gerente.addUsuario();
        gerente.cadastrarVeiculo(Focus);

        while (true) {
            menu();
        }
    }

    public static void menu() {
        System.out.println("""
                1 - Login
                2 - Cadastro
                3 - Ver estoque
                4 - Ver detalhes de um veiculo
                """);

        if (logado != null) {
            System.out.println(logado.menuFuncionario());

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

        System.out.println(acao);
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
                        case 19 -> alterarPrecoVeiculo();
                    }
                }
            }
        }
    }

    public static void alterarPrecoVeiculo() {
        String codigo = pedirCodigoVeiculo();
        System.out.println("Insira o novo preço: ");
        float preco = sc.nextFloat();

        ((Gerente) logado).alterarPreco(codigo, preco);
        System.out.println("Preço alterado!");
    }

    public static String pedirNome() {
        System.out.println("Insira o nome: ");
        return sc.next();
    }

    public static String pedirSenha() {
        System.out.println("Insira a senha: ");
        return sc.next();
    }

    public static String pedirCNH() {
        System.out.println("Insira a CNH: ");
        return sc.next();
    }

    public static String pedirCodigoVeiculo(){
        System.out.println("Insira o codigo do veiculo: ");
        return sc.next();
    }

    public static String pedirCPF() {
        System.out.println("Insira o cpf: ");
        return sc.next();
    }

    public static void sair() {
        logado = null;
    }

    public static void verPagamento() {
        System.out.println("Pagamento: "+ ((Funcionario) logado).verPagamento());
    }

    public static void procurarCliente() {
        String cpf = pedirCPF();
        System.out.println(((Funcionario) logado).procurarCliente(cpf));
    }

    public static void venderUmVeiculo() {
        String codigo = pedirCodigoVeiculo();
        Veiculo veiculo = Veiculo.getVeiculo(codigo);
        if (veiculo == null) {
            System.out.println("Veiculo não existe");
            return;
        }

        String cpf = pedirCPF();
        Usuario cliente = Usuario.getUsuario(cpf);
        if (cliente == null) {
            System.out.println("Usuario nao existe");
            return;
        }

        ((Funcionario) logado).venderVeiculo(codigo, cliente);
        System.out.println("Vendido");
    }

    public static void verMeusVeiculos() {
        for (Veiculo veiculo: logado.verMeusVeiculos()) {
            System.out.println(veiculo.toString());
        }
    }

    public static void verDetalhesDeUmVeiculo() {
        String codigo = pedirCodigoVeiculo();
        System.out.println(Veiculo.verVeiculo(codigo));
    }

    public static void verEstoque() {
        for (Veiculo veiculo: Veiculo.getVeiculos()) {
            System.out.println(veiculo.getInformacoesParaListarEstoque());
        }
    }

    public static void cadastroDeCliente() {
        String nome = pedirNome();
        String senha = pedirSenha();
        String cpf = pedirCPF();
        String cnh = pedirCNH();

        Cliente cliente = new Cliente(nome, cpf, senha, cnh);
        cliente.addUsuario();
    }

    public static void login() {
        String cpf = pedirCPF();
        String senha = pedirSenha();

        try {
            logado = Usuario.login(cpf, senha);
        } catch (UsuarioNaoEncontradoException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Deseja realizar o cadastro?");
            System.out.println("""
                    1 - Sim;
                    outro - Não
                    """);

            int entrada = sc.nextInt();
            if (entrada == 1) {
                cadastroDeCliente();
            }
        } catch (SenhaIncorretaException exception) {

        }

    }

    public static Veiculo menuCadastrarVeiculo() {
        System.out.println("Qual tipo de veiculo deseja cadastrar/Editar:");
        System.out.println("""
                1 - Carro
                2 - Moto
                3 - Caminhão
                """);

        int tipoVeiculo = sc.nextInt();
        System.out.println("Insira a marca do veículo:");
        String marca = sc.next();
        System.out.println("Insira o modelo do veículo:");
        String modelo = sc.next();
        System.out.println("Insira a placa do veículo:");
        String placa = sc.next();
        System.out.println("Insira o código do veículo:");
        String codigo = sc.next();
        System.out.println("O veículo é novo? (true/false):");
        boolean novo = sc.nextBoolean();
        System.out.println("Insira o status do veículo: (Disponivel/Vendido)");
        String status = sc.next();
        System.out.println("Insira a quilometragem do veículo:");
        int quilometragem = sc.nextInt();
        System.out.println("Insira o ano do veículo:");
        int ano = sc.nextInt();
        System.out.println("Insira o preço do veículo:");
        float preco = sc.nextFloat();

        Veiculo veiculoGenerico = null;

        switch (tipoVeiculo) {
            case 1 -> veiculoGenerico = new Carro(marca, modelo, placa, codigo, novo, status, quilometragem, ano, preco);
            case 2 -> veiculoGenerico = new Moto(marca, modelo, placa, codigo, novo, status, quilometragem, ano, preco);
            case 3 -> {
                System.out.println("Insira o peso máximo do veículo:");
                int pesoMaximo = sc.nextInt();
                System.out.println("Insira o comprimento do veículo:");
                float comprimento = sc.nextInt();
                System.out.println("Insira a quantidade de rodas do veículo:");
                int quantidadeDeRodas = sc.nextInt();
                veiculoGenerico = new Caminhao(marca, modelo, placa, codigo, novo, status, quilometragem, ano, preco, pesoMaximo, comprimento, quantidadeDeRodas);
            }
        }
        return veiculoGenerico;
    }

    public static void cadastrarVeiculo() {
        Veiculo veiculoGenerico = menuCadastrarVeiculo();

        if (veiculoGenerico != null) {
            veiculoGenerico.addVeiculo();
            System.out.println("O veiculo foi cadastrado com sucesso!");
        }else {
            System.out.println("Não foi possivel cadastrar o veiculo!");
        }
    }

    public static void editarUsuario() {
        String cpf = pedirCPF();
        Usuario usuario = Usuario.getUsuario(cpf);

        if (usuario == null) {
            System.out.println("Não existe nenhum usuário com esse cpf!");
            return;
        }

        Usuario novoUsuario = menuCadastrarUsuario();
        ((Gerente) logado).editarUmUsuario(novoUsuario);
        System.out.println("Usuário editado!");
    }

    public static void removerVeiculo() {
        String codigo = pedirCodigoVeiculo();
        ((Gerente) logado).removerVeiculo(codigo);
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
        String nome = pedirNome();
        String cpf = pedirCPF();
        String senha = pedirSenha();

        switch (tipoUsuario) {
            case 1 -> {
                String cnh = pedirCNH();
                usuario = new Cliente(nome, cpf, senha, cnh);
            }
            case 2 -> {
                System.out.println("Insira o salario do usuario: ");
                float salario = sc.nextFloat();
                usuario = new Vendedor(nome, cpf, senha, salario);
            }
        }

        return usuario;
    }

    public static void verPagamentosDosVendedores() {
        System.out.println("Pagamento: "+ ((Gerente) logado).verPagamentos());
    }

    public static void removerUsuario() {
        String cpf = pedirCPF();
        System.out.println(((Gerente) logado).removerUsuario(cpf));
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
        String cpf = pedirCPF();
        Usuario vendedor = Usuario.getUsuario(cpf);

        if (vendedor == null) {
            System.out.println("Vendedor não existe!");
            return;
        }
        if (!(vendedor instanceof  Vendedor)) {
            System.out.println("Usuário não é um vendedor!");
            return;
        }

        System.out.println(((Gerente) logado).verPagamentoDeUmVendedor(cpf));
    }
}