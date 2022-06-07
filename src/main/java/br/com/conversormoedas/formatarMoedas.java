
package br.com.conversormoedas;

public class formatarMoedas {
    public static String formatarMoedas(Object moeda) {
        
        String moedaSTR = (String) moeda;
        
        
        int indice1 = moedaSTR.indexOf("(") + 1;
        int indice2 = moedaSTR.indexOf(")");
        
        
        
        return moedaSTR.substring(indice1, indice2);
    }
}
