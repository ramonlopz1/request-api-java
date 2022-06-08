
package br.com.conversormoedas;

import javax.swing.JOptionPane;

public class InserirQuantiaOriginal {
    
    public static Object setQuantiaOriginal(Object moedaOriginal) {
        
        // Renderiza o input em que o usuário irá inserir a quantia original.
        
        Object quantiaOriginal = JOptionPane.showInputDialog(null, 
                "Insira a quantia de " + moedaOriginal,
                    "Quantia",
                    JOptionPane.INFORMATION_MESSAGE
            );

        return quantiaOriginal.toString();
    }
}
