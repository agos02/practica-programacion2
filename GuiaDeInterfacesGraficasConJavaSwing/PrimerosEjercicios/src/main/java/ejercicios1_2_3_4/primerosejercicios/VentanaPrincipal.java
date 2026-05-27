package ejercicios1_2_3_4.primerosejercicios;
import javax.swing.*;
import java.awt.event.*;

public class VentanaPrincipal {
    JFrame ventana;
    JPanel panel;
    JButton boton;
    JLabel texto;

    public VentanaPrincipal(){ //3.1 Ventana Principal
        ventana = new JFrame("Panel de preferencias");
        ventana.setSize(500,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        ventana.add(panel);

        texto = new JLabel("Opciones seleccionadas: Ninguna");
        boton = new JButton("Configurar Preferencias");

        panel.add(texto);
        panel.add(boton);

        //3.4 Interacción 1:
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaDialogo dialogo = new VentanaDialogo(ventana, texto);
                dialogo.setVisible(true);
            }
        });

        ventana.setVisible(true);
    }
}
