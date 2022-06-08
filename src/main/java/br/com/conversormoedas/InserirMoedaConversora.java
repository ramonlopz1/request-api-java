package br.com.conversormoedas;

import static br.com.conversormoedas.ListaDeMoedas.listaDeMoedas;
import javax.swing.JOptionPane;

public class InserirMoedaConversora {

    public static Object setMoedaConversora() {
        
        // Renderiza o input em que o usuário irá selecionar a moeda conversora.
        Object moedaConversora = JOptionPane.showInputDialog(
                null,
                "Selecione a moeda conversora:",
                "Moeda Conversora",
                JOptionPane.QUESTION_MESSAGE, 
                null,
                listaDeMoedas(),
                "Escolha"
        );

        // Botão cancelar encerra o programa
        if (moedaConversora == null) {
            System.exit(0);
        }

        return moedaConversora;
    }
}
