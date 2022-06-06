package br.com.conversormoedas;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Inicio {

    public static void main(String[] args) throws IOException {

        // Usuário insere a moeda original.
        Object moedaOriginal = JOptionPane.showInputDialog(
                null,
                "Selecione a sua moeda:",
                "Moedas",
                JOptionPane.QUESTION_MESSAGE, // INFORMATION_MESSAGE, WARNING_MESSAGE
                null,
                new Object[]{"Real", "Pesos", "Dolar"}, "Escolha"
        );

        // Usuário insere a quantia.
        String quantiaOriginal = JOptionPane.showInputDialog(null, "Insira a quantia de " + moedaOriginal);

        // Usuário insere a moeda conversora.
        Object moedaConversora = JOptionPane.showInputDialog(
                null,
                "Selecione a moeda conversora:",
                "Moedas",
                JOptionPane.QUESTION_MESSAGE, // INFORMATION_MESSAGE, WARNING_MESSAGE
                null,
                new Object[]{"Real", "Pesos", "Dolar"}, "Escolha"
        );

        while(moedaOriginal == moedaConversora) {
            // Usuário insere a quantia.
             JOptionPane.showMessageDialog(null, "Você não pode escolher a mesma moeda.");
            
       
            // Usuário insere a moeda conversora.
            moedaConversora = JOptionPane.showInputDialog(
                    null,
                    "Selecione a moeda conversora:",
                    "Moedas",
                    JOptionPane.QUESTION_MESSAGE, // INFORMATION_MESSAGE, WARNING_MESSAGE
                    null,
                    new Object[]{"Real", "Pesos", "Dolar"}, "Escolha"
            );
        }
        
        Conversao c = new Conversao();

        System.out.println(c.converter(quantiaOriginal, moedaOriginal, moedaConversora));;
    }
}
