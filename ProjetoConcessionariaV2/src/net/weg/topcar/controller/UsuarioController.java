package net.weg.topcar.controller;

import net.weg.topcar.view.*;

class ClienteController {
    private final Entrada<Long> entradaLongo = new EntradaInteiro();
    private final Entrada<String> entradaTexto = new EntradaTexto();
    private final Entrada<Float> entradaDecimal = new EntradaDecimal();
    private final Saida saida = new Saida();

    public void cadastroCliente() {
        String nome = entradaTexto.leia("Insira o seu nome: ", saida);
        String cpf = entradaTexto.leia("Informe seu cpf: ", saida);
        String senha = entradaTexto.leia("Informe sua senha: ", saida);
        String confSenha = entradaTexto.leia("Confirme sua senha: ", saida);

        
    }
}
