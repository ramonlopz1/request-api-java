package br.com.conversormoedas;

import static br.com.conversormoedas.formatarMoedas.formatarMoedas;
import java.io.IOException;
import java.text.DecimalFormat;

public class Conversao {
    
    // Recebe a moeda Original, a moeda conversora e a quantia original
    public String converter(String quantiaOriginal, Object moedaOriginal, Object moedaConversora)
            throws IOException {

        // Divide a quantia original, pelo valor da moedaConversora vinda da API, resultando no valorConvertido.
        double valorConvertido = Double.valueOf(quantiaOriginal) / Double.valueOf(moneyRequestAPI(moedaOriginal, moedaConversora));

        return new DecimalFormat("#.##").format(valorConvertido);
    }

    // Define o tipo de moeda e faz requisição para a API.
    public String moneyRequestAPI(Object moedaOriginal, Object moedaConversora) {
        String moedaOriginalSTRING = formatarMoedas(moedaOriginal);
        String moedaConversoraSTRING = formatarMoedas(moedaConversora);

        // Recebe as moedas, ex: USD-BRL e faz requisição para a moneyAPI
        String valorDaMoedaConversoraAPI = moneyAPI.sendRequestAPI(moedaConversoraSTRING, moedaOriginalSTRING);

        return valorDaMoedaConversoraAPI.toString();
    }
}
