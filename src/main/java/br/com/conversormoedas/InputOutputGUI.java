/**
 * Renderiza o UI e aplica a lógica de passos
 */
package br.com.conversormoedas;

import java.io.IOException;
import javax.swing.JOptionPane;

public class InputOutputGUI {

    public static void main(String[] args) throws IOException {
        int novaConversao = IniciarAplicacao.start();
        
        if(novaConversao == JOptionPane.YES_NO_OPTION) {
            IniciarAplicacao.start();
        } else {
            System.exit(0);
        }
    }
}
