package br.com.conversormoedas;

import static br.com.conversormoedas.ListaDeMoedas.listaDeMoedas;

import javax.swing.JOptionPane;


public class InserirMoedaOriginal {
    
    public static Object setMoedaOriginal() {
        
        // Renderiza o input em que o usuário irá selecionar a moeda original.
        Object moedaOriginal = JOptionPane.showInputDialog(
                null,
                "Selecione a sua moeda:", // Texto do input
                "Sua Moeda", // Título da janela
                JOptionPane.QUESTION_MESSAGE, // INFORMATION_MESSAGE, WARNING_MESSAGE
                null,
                listaDeMoedas(), // renderiza a lista de opções
                "Escolha"
        );
        
        if (moedaOriginal == null) {
            System.exit(0);
        }
        
        return moedaOriginal;
    }
}
