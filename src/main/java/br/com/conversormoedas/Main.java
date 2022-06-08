/**
 * Renderiza o Graphic User Interactive - GUI
 */
package br.com.conversormoedas;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws IOException {
        int novaConversao = OrdemDeExecucao.start();
        
        // se, ao finalizar a conversão, o usuário selecionar Yes, o app roda novamente
        if(novaConversao == JOptionPane.YES_NO_OPTION) {
            OrdemDeExecucao.start();
        } else {
            System.exit(0);
        }
    }
}
