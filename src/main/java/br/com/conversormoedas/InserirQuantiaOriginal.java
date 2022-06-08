
package br.com.conversormoedas;

import javax.swing.JOptionPane;

public class InserirQuantiaOriginal {
    public static Object setQuantiaOriginal(Object moedaOriginal) {
        Object quantiaOriginal = JOptionPane.showInputDialog(null, 
                "Insira a quantia de " + moedaOriginal,
                    "Quantia",
                    JOptionPane.INFORMATION_MESSAGE
            );

        return quantiaOriginal.toString();
    }
}
