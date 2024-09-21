
package com.mycompany.proyecto1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author cesar
 */
public class Proyecto1 {

public static void main(String[] args) {
        // Ejecuta el código en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crea una instancia del JFrame
                JFrame frame = new JFrame("Compilador");
                // Crea una instancia de tu panel Compilador
                Compilador panel = new Compilador();
                
                // Configura el JFrame
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(panel);
                frame.pack();  // Ajusta el tamaño del JFrame al tamaño preferido del panel
                frame.setLocationRelativeTo(null);  // Centra la ventana en la pantalla
                frame.setVisible(true);  // Muestra la ventana
            }
        });
    }
}
