package br.com.conversormoedas;

// Nos inputs temos a String Real (BRL), Dolar (USD) e etc.
// essa classe remove todos os elementos exceto o BRL e USD. Para que sejam passados no URL da API.
public class FormatarMoedas {
    public static String formatarMoedas(Object moeda) {
        String moedaSTR = (String) moeda;
        int indice1 = moedaSTR.indexOf("(") + 1;
        int indice2 = moedaSTR.indexOf(")");
        
        return moedaSTR.substring(indice1, indice2);
    }
}
