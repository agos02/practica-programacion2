package ejercicios1_2_3_4.primerosejercicios;

import javax.swing.*; //Importamos el paquete que contiene los controles Swing 
import java.awt.event.*;

public class EditorTexto implements ActionListener {
    JFrame ventana;
    JTextArea areaDeTexto;
    JMenuItem limpiarItem, salirItem;
    
    public EditorTexto(){
        ventana = new JFrame("Pequeño editor de texto"); //2.1
        ventana.setSize(500,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar automaticamente al salirr
        ventana.setVisible(true);

        JMenuBar menuBarra = new JMenuBar(); //2.2
        ventana.setJMenuBar(menuBarra);
        
        JMenu menuArchivo = new JMenu("Archivo");//2.3
        menuBarra.add(menuArchivo);
        
        limpiarItem = new JMenuItem ("Limpiar texto"); //2.4
        salirItem = new JMenuItem ("Salir");
        menuArchivo.add(limpiarItem);
        menuArchivo.add(salirItem);
        
        limpiarItem.addActionListener(this);//2.6
        salirItem.addActionListener(this);

        
        areaDeTexto = new JTextArea(); //2.5
        JScrollPane scroll = new JScrollPane(areaDeTexto);
        ventana.add(scroll);
    }
    
    
        @Override
        public void actionPerformed(ActionEvent e) { //2.6
            if (e.getSource() == limpiarItem) {
                areaDeTexto.setText(""); // borra todo el texto
            } else if (e.getSource() == salirItem) {
                System.exit(0); // cierra el programa
        }
    }

}