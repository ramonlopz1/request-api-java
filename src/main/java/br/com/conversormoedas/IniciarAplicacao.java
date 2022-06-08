/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.conversormoedas;

import static br.com.conversormoedas.FormatarMoedas.formatarMoedas;
import static br.com.conversormoedas.InserirMoedaConversora.setMoedaConversora;
import static br.com.conversormoedas.InserirMoedaOriginal.setMoedaOriginal;
import static br.com.conversormoedas.InserirQuantiaOriginal.setQuantiaOriginal;
import static br.com.conversormoedas.ListaDeMoedas.listaDeMoedas;
import java.io.IOException;
import javax.swing.JOptionPane;

public class IniciarAplicacao {

    public static int start() throws IOException {
        // Inicializa a variável moedaConversora do tipo Object;
        Object moedaConversora = null;

        // Usuário insere a moeda original.
        Object moedaOriginal = setMoedaOriginal();
        

        String quantiaOriginal;
        

        // Testa se o usuário inseriu números com REGEX, 
        // se sim, continua executando os próximos passos, senão, repete ação de pedir números.
        do {
            // Usuário insere a quantia.
            quantiaOriginal = (String) setQuantiaOriginal(moedaOriginal);

            // Se for apenas números:
            if (quantiaOriginal.matches("^[0-9]+$")) {
                // Usuário insere a moeda conversora.
                
                moedaConversora = setMoedaConversora();

                // Impede que repita a moeda original, na moeda conversora:
                while (moedaOriginal == moedaConversora) {
                    // Alerta
                    JOptionPane.showMessageDialog(null, "Você não pode escolher a mesma moeda.");

                    // Usuário insere a moeda conversora.
                    moedaConversora = setMoedaConversora();
                }
            }

        } while (quantiaOriginal.matches("^[0-9]+$") == false); // enquanto não inserir apenas números (REGEX)

        Conversao c = new Conversao();

        String resultadoFinal = c.converter(quantiaOriginal, moedaOriginal, moedaConversora);

        int opcoesFinais = JOptionPane.showConfirmDialog(
                null,
                "Valor convertido: $" + resultadoFinal + " "
                + formatarMoedas(moedaConversora),
                "Resultado",
                JOptionPane.YES_NO_OPTION
        );

        return opcoesFinais;
    }
}
