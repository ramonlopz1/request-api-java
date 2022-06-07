package br.com.conversormoedas;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Inicio {

    public static void main(String[] args) throws IOException {
        // Inicializa a variável moedaConversora do tipo Object;
        Object moedaConversora = null;
        
        // Usuário insere a moeda original.
        Object moedaOriginal = JOptionPane.showInputDialog(
                null,
                "Selecione a sua moeda:",
                "Moedas",
                JOptionPane.QUESTION_MESSAGE, // INFORMATION_MESSAGE, WARNING_MESSAGE
                null,
                new Object[]{
                    "Real (BRL)", //5 - 9
                    "Pesos Argentinos(ARS)", //15 - 19
                    "Dolar (USD)",
                    "EURO (EUR)",
                    "LIBRAS (LBR)",
                    "Pesos Chilenos (LBR)"
                },
                "Escolha"
        );

        String quantiaOriginal;

        // Testa se o usuário inseriu números com REGEX, 
        // se sim, continua executando os próximos passos, senão, repete ação de pedir números.
        do {
            // Usuário insere a quantia.
            quantiaOriginal = JOptionPane.showInputDialog(null, "Insira a quantia de " + moedaOriginal);

            // Se for apenas números:
            if (quantiaOriginal.matches("^[0-9]*$")) {
                // Usuário insere a moeda conversora.
                moedaConversora = JOptionPane.showInputDialog(
                        null,
                        "Selecione a moeda conversora:",
                        "Moedas",
                        JOptionPane.QUESTION_MESSAGE, // INFORMATION_MESSAGE, WARNING_MESSAGE
                        null,
                        new Object[]{
                            "Real (BRL)",
                            "Pesos Argentinos(ARS)",
                            "Dolar (USD)",
                            "EURO (EUR)",
                            "LIBRAS (LBR)",
                            "Pesos Chilenos (LBR)"
                        },
                        "Escolha"
                );

                // Impede que repita a moeda original, na moeda conversora:
                while (moedaOriginal == moedaConversora) {
                    // Usuário insere a quantia.
                    JOptionPane.showMessageDialog(null, "Você não pode escolher a mesma moeda.");

                    // Usuário insere a moeda conversora.
                    moedaConversora = JOptionPane.showInputDialog(
                            null,
                            "Selecione a moeda conversora:",
                            "Moedas",
                            JOptionPane.QUESTION_MESSAGE, // INFORMATION_MESSAGE, WARNING_MESSAGE
                            null,
                            new Object[]{
                                "Real (BRL)",
                                "Pesos Argentinos(ARS)",
                                "Dolar (USD)",
                                "EURO (EUR)",
                                "LIBRAS (LBR)",
                                "Pesos Chilenos (LBR)"
                            },
                            "Escolha"
                    );
                }

            } 
            
        } while (quantiaOriginal.matches("^[0-9]*$") == false);

        Conversao c = new Conversao();

        System.out.println(c.converter(quantiaOriginal, moedaOriginal, moedaConversora));
    }
}
