package javaapplication1;

import javax.swing.JFrame;
import view.TelaPrincipal;

public class JavaApplication1 {

    public static void main(String[] args) {
        TelaPrincipal frame = new TelaPrincipal();
        frame.setTitle("Gerenciador de eventos culinários");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
