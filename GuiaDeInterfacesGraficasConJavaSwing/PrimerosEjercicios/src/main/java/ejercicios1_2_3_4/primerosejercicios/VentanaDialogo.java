package ejercicios1_2_3_4.primerosejercicios;

import javax.swing.*;
import java.awt.event.*;

class VentanaDialogo extends JDialog implements ActionListener {

    JCheckBox checkOscuro, checkNotificaciones, checkAutoguardado;
    JButton botonAceptar;
    JLabel etiquetaPrincipal;

    public VentanaDialogo(JFrame padre, JLabel etiquetaPrincipal){ 
        super(padre, "Preferencias", true); //3.2 Crear JDialog modal con título
        this.etiquetaPrincipal = etiquetaPrincipal;

        setSize(300,200);
        setLocationRelativeTo(padre);

        JPanel panel = new JPanel(); //3.3 

        checkOscuro = new JCheckBox("Modo oscuro");
        checkNotificaciones = new JCheckBox("Notificaciones");
        checkAutoguardado = new JCheckBox("Autoguardado");
        botonAceptar = new JButton("Aceptar");

        panel.add(checkOscuro);
        panel.add(checkNotificaciones);
        panel.add(checkAutoguardado);
        panel.add(botonAceptar);

        add(panel);

        botonAceptar.addActionListener(this); //3.5
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String seleccion = "Opciones seleccionadas: ";
        boolean algoMarcado = false;

        if (checkOscuro.isSelected()) {
            seleccion += "Modo Oscuro ";
            algoMarcado = true;
        }
        if (checkNotificaciones.isSelected()) {
            seleccion += "Notificaciones ";
            algoMarcado = true;
        }
        if (checkAutoguardado.isSelected()) {
            seleccion += "Autoguardado ";
            algoMarcado = true;
        }

        if (!algoMarcado) {   //3.6 Si ninguna está marcada
            seleccion += "Ninguna"; 
        }

        etiquetaPrincipal.setText(seleccion);
        dispose(); // cerrar el diálogo
    }
}
