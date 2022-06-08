/**
 * Renderiza o UI e aplica a lógica de passos
 */
package br.com.conversormoedas;

import static br.com.conversormoedas.FormatarMoedas.formatarMoedas;
import java.io.IOException;
import javax.swing.JOptionPane;

public class InputOutputGUI {

    public static void main(String[] args) throws IOException {
        // Inicializa a variável moedaConversora do tipo Object;
        Object moedaConversora = null;
        
        Object[] listaDeMoedas = {
            "Real (BRL)", 
            "Pesos Argentinos(ARS)",
            "Dolar (USD)",
            "EURO (EUR)",
            "Libras Esterlinas (GBP)",
            "Pesos Chilenos (LBR)"
        };
        
        System.out.println(listaDeMoedas);

        // Usuário insere a moeda original.
        Object moedaOriginal = JOptionPane.showInputDialog(
                null,
                "Selecione a sua moeda:", // Texto do input
                "Sua Moeda", // Título da janela
                JOptionPane.QUESTION_MESSAGE, // INFORMATION_MESSAGE, WARNING_MESSAGE
                null,
                listaDeMoedas, // renderiza a lista de opções
                "Escolha"
        );

        String quantiaOriginal;

        // Botão cancelar encerra o programa
        if (moedaOriginal == null) {
            System.exit(0);
        }

        // Testa se o usuário inseriu números com REGEX, 
        // se sim, continua executando os próximos passos, senão, repete ação de pedir números.
        do {
            // Usuário insere a quantia.
            quantiaOriginal = JOptionPane.showInputDialog(null, "Insira a quantia de " + moedaOriginal, 
                        "Quantia", 
                        JOptionPane.INFORMATION_MESSAGE
            );

            // Botão cancelar encerra o programa
            if (quantiaOriginal == null) {
                System.exit(0);
            }

            // Se for apenas números:
            if (quantiaOriginal.matches("^[0-9]+$")) {
                // Usuário insere a moeda conversora.
                moedaConversora = JOptionPane.showInputDialog(
                        null,
                        "Selecione a moeda conversora:",
                        "Moeda Conversora",
                        JOptionPane.QUESTION_MESSAGE, // INFORMATION_MESSAGE, WARNING_MESSAGE
                        null,
                        listaDeMoedas,
                        "Escolha"
                );

                // Botão cancelar encerra o programa
                if (moedaConversora == null) {
                    System.exit(0);
                }

                // Impede que repita a moeda original, na moeda conversora:
                while (moedaOriginal == moedaConversora) {
                    // Alerta
                    JOptionPane.showMessageDialog(null, "Você não pode escolher a mesma moeda.");

                    // Usuário insere a moeda conversora.
                    moedaConversora = JOptionPane.showInputDialog(
                            null,
                            "Selecione a moeda conversora:",
                            "Moeda Conversora",
                            JOptionPane.QUESTION_MESSAGE, // INFORMATION_MESSAGE, WARNING_MESSAGE
                            null,
                            listaDeMoedas,
                            "Escolha"
                    );

                    if (moedaConversora == null) {
                        System.exit(0);
                    }
                }
            }

        } while (quantiaOriginal.matches("^[0-9]+$") == false); // enquanto não inserir apenas números (REGEX)

        Conversao c = new Conversao();

        String resultadoFinal = c.converter(quantiaOriginal, moedaOriginal, moedaConversora);
        JOptionPane.showMessageDialog(null, "Valor convertido: $" + resultadoFinal + " " + formatarMoedas(moedaConversora));
    }
}
