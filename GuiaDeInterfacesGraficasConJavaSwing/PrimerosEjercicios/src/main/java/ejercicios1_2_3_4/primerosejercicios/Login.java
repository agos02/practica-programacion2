package ejercicios1_2_3_4.primerosejercicios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JPanel panel;
    JPasswordField contraseñaUsuario;
    private String contraseñaSecreta = "agoscontraseña";
    
 public Login (){ //Ejercicio 4:
     setSize(400,400);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     panel = new JPanel(); //4.1
     add(panel);
     
     JLabel textoUsuario = new JLabel("Usuario:"); //4.2
     JTextField campoUsuario = new JTextField(20);
     JPanel panelUsuario = new JPanel();
     panelUsuario.add(textoUsuario);
     panelUsuario.add(campoUsuario);

     panel.add(panelUsuario);
     
     JLabel textoContraseña = new JLabel("Contraseña:"); //4.3
     contraseñaUsuario = new JPasswordField("", 20);
     JPanel panelContraseña = new JPanel();
     panelContraseña.add(textoContraseña);
     panelContraseña.add(contraseñaUsuario);
     
     panel.add(panelContraseña);
     
     
     contraseñaUsuario.setEchoChar('*'); //4.4
     
     JButton botonAcceder = new JButton("Acceder"); //4.5
     panel.add(botonAcceder);
     
     botonAcceder.addActionListener(this);//4.6me 
     
     

     setVisible(true);
 }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        char[] traerContraseña = contraseñaUsuario.getPassword(); //4.7
        String contraseñaObtenida = String.valueOf(traerContraseña);
        
        if(contraseñaObtenida.equals(contraseñaSecreta)){ //4.8
            JOptionPane.showMessageDialog(null, "Acceso correcto");
        }
        else{
            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
        }
    }

}