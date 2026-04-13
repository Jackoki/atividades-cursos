package src.br.com.alura;

import java.math.BigDecimal;

public class AppBanco {
    public static void main(String[] args) {
        var cliente = new Cliente("João");
        var conta = new Conta(cliente, new BigDecimal("150"));
        
        var operacao = new OperacaoSaque(conta, new BigDecimal("150"));

        operacao.executa();

        operacao.executa();
    }
}
