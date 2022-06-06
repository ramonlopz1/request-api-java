package br.com.conversormoedas;

import java.io.IOException;
import java.text.DecimalFormat;

public class Conversao {
    double valorConvertido;
    String valorDaMoedaConversoraAPI;

    // Recebe a moeda Original, a moeda conversora e a quantia original
    public String converter(String quantiaOriginal, Object moedaOriginal, Object moedaConversora)
            throws IOException {

        // quantiaOriginal / valorMoedaConversoraAPI = valoConvertido
        valorConvertido = calcularConversao(quantiaOriginal, moneyRequestAPI(moedaOriginal, moedaConversora));

        return new DecimalFormat("#.##").format(valorConvertido);
    }

    // Divide a quantia original, pelo valor da moedaConversora vinda da API, resultando no valorConvertido.
    public Double calcularConversao(String quantiaOriginal, String valorDaMoedaConversoraAPI) {
        return Double.valueOf(quantiaOriginal) / Double.valueOf(valorDaMoedaConversoraAPI);
    }

    // Define o tipo de moeda e faz requisição para a API.
    public String moneyRequestAPI(Object moedaOriginal, Object moedaConversora) {

        // REAL
        if (moedaOriginal.equals("Real") && moedaConversora.equals("Real")) {
            valorDaMoedaConversoraAPI = moneyAPI.sendRequestAPI("BRL", "BRL");

        }  else if (moedaOriginal.equals("Real") && moedaConversora.equals("Pesos")) {
            valorDaMoedaConversoraAPI = moneyAPI.sendRequestAPI("MXN", "BRL");

        } else if (moedaOriginal.equals("Real") && moedaConversora.equals("Dolar")) {
            valorDaMoedaConversoraAPI = moneyAPI.sendRequestAPI("USD", "BRL");
        } 
        
        // PESOS
        if (moedaOriginal.equals("Pesos") && moedaConversora.equals("Pesos")) {
            valorDaMoedaConversoraAPI = moneyAPI.sendRequestAPI("MXN", "MXN");
        } else if (moedaOriginal.equals("Pesos") && moedaConversora.equals("Real")) {
            valorDaMoedaConversoraAPI = moneyAPI.sendRequestAPI("BRL", "MXN");

        } else if (moedaOriginal.equals("Pesos") && moedaConversora.equals("Dolar")) {
            valorDaMoedaConversoraAPI = moneyAPI.sendRequestAPI("USD", "MXN");
        }
        
        // DOLAR
        if (moedaOriginal.equals("Dolar") && moedaConversora.equals("Dolar")) {
            valorDaMoedaConversoraAPI = moneyAPI.sendRequestAPI("USD", "USD");
        } else if (moedaOriginal.equals("Dolar") && moedaConversora.equals("Pesos")) {
            valorDaMoedaConversoraAPI = moneyAPI.sendRequestAPI("MXN", "USD");

        } else if (moedaOriginal.equals("Dolar") && moedaConversora.equals("Real")) {
            valorDaMoedaConversoraAPI = moneyAPI.sendRequestAPI("BRL", "USD");
        }

        return valorDaMoedaConversoraAPI.toString();
    }
}
