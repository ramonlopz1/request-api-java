package br.com.conversormoedas;

import static br.com.conversormoedas.Conversao.converter;
import static br.com.conversormoedas.FormatarMoedas.formatarMoedas;
import static br.com.conversormoedas.InserirMoedaConversora.setMoedaConversora;
import static br.com.conversormoedas.InserirMoedaOriginal.setMoedaOriginal;
import static br.com.conversormoedas.InserirQuantiaOriginal.setQuantiaOriginal;
import java.io.IOException;
import javax.swing.JOptionPane;

public class OrdemDeExecucao {

    public static int start() throws IOException {
        Object moedaConversora = null;
        Object moedaOriginal = setMoedaOriginal(); // Usuário insere a moeda original.
        String quantiaOriginal;
        
        do {
            // Usuário insere a quantia.
            quantiaOriginal = (String) setQuantiaOriginal(moedaOriginal);

            // Testa, com REGEX, se a quantiaOriginal contém apenas números
            // Se houver apenas números ponto ou vírgula, continua a execução, senão repete a solicitação de números
            if (quantiaOriginal.matches("^\\d+[.|,]?\\d+[.|,]?\\d*")) {
                
                if(quantiaOriginal.contains(",")) {
                    quantiaOriginal = quantiaOriginal.replace(",", ".");
                }
                
                // Se o REGEX der match: Usuário seleciona a moeda conversora.
                moedaConversora = setMoedaConversora();

                // Impede que repita a moeda original, na moeda conversora:
                while (moedaOriginal == moedaConversora) {
                    // Alerta
                    JOptionPane.showMessageDialog(null, "Você não pode escolher a mesma moeda.");

                    // Usuário insere a moeda conversora novamente.
                    moedaConversora = setMoedaConversora();
                }
            }
            // Repete os passos enquanto o REGEX não der match [0-9]
        } while (quantiaOriginal.matches("^\\d+[.|,]?\\d+[.|,]?\\d*") == false);

        // Após receber todas as informações, tratadas, dos inputs, realiza a conversão
        String valorConvertido = converter(quantiaOriginal, moedaOriginal, moedaConversora);

        int resultado = JOptionPane.showConfirmDialog(
                null,
                "Valor convertido: $" + valorConvertido + " "
                + formatarMoedas(moedaConversora),
                "Resultado",
                JOptionPane.YES_NO_OPTION
        );

        return resultado;
    }
}
