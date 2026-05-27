package ejercicios1_2_3_4.primerosejercicios;
import javax.swing.*; //Importamos el paquete que contiene los controles Swing 
import java.awt.event.*;
public class Formulario implements ActionListener{  
    
    JFrame ventana;
    JPanel panel;
    JLabel textoNombre;
    JTextField campoNombre;
    JButton boton;
    JLabel textoVacio;
    
    public Formulario(){
        
        ventana = new JFrame("Formulario"); //1.1
        ventana.setSize(400,300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel(); //1.2
        ventana.add(panel);
        
        textoNombre = new JLabel("Introduce tu nombre"); //1.3
        campoNombre = new JTextField(20);
        panel.add(textoNombre);
        panel.add(campoNombre);
        
        boton = new JButton("Saludar"); //1.4
        boton.addActionListener(this);
        textoVacio = new JLabel("");
        panel.add(boton);
        panel.add(textoVacio);
        
        ventana.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){ //1.5
        String nombre = campoNombre.getText();
        textoVacio.setText("Hola " + nombre + "!!");
    }
}