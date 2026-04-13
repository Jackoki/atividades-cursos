package src.br.com.alura;

import java.math.BigDecimal;

public class AppBanco {
    public static void main(String[] args) {
        var cliente = new Cliente("João");
        var conta = new Conta(cliente, new BigDecimal("150"));
        
        var operacao = new OperacaoSaque(conta, new BigDecimal("150"));

        Thread saqueJoao = new Thread(operacao);
        Thread saqueMaria = new Thread(operacao);

        saqueJoao.start();
        saqueMaria.start();

        
        try {
            //Declara a sincronização entre as funções das threads com a função atual do main
            //Faz com que a execução espere até que essa thread termine para continuar
            saqueJoao.join();
            saqueMaria.join();
        }

        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
