package vista;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    public JTextField usuario;
    public JTextField claveField;
    public JButton entrar;

    public LoginForm(){
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Santander - Inicia sesion");
        setIconImage(new ImageIcon( "src/media/icono.png").getImage());

        Font headlineFont = new Font("Headline", Font.PLAIN, 16);
        Font headlineFontBold = new Font("Headline", Font.BOLD, 16);

        JLabel titulo = new JLabel("Te damos la bienvenida a tu Banca Online");
        Dimension size = titulo.getPreferredSize();
        titulo.setFont(headlineFont);
        titulo.setBounds(150, 10, 300, size.height);



        usuario = new JTextField("Usuario");
        usuario.setFont(headlineFont);
        usuario.setBounds(150, 80, (300 - 90) + 80 + 6, 30);

        claveField = new JTextField("Clave de acceso");
        claveField.setFont(headlineFont);
        claveField.setBounds(150, 140, (300 - 90) + 80 + 6, 30);


        entrar = new JButton("Entrar");
        entrar.setBounds(300, 190, 145, 40);
        entrar.setBackground(Color.RED);
        entrar.setBorder(null);
        entrar.setFont(headlineFontBold);
        entrar.setForeground(Color.WHITE);



        JButton problemas = new JButton("¿Problemas con tu clave de acceso?");
        problemas.setBounds(250, 240, problemas.getPreferredSize().width, size.height);
        problemas.setBackground(null);
        problemas.setContentAreaFilled(false);
        problemas.setOpaque(false);
        problemas.setBorderPainted(false);


        add(titulo);
        add(usuario);
        add(claveField);
        add(entrar);
        add(problemas);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getusuario() {
        return (String) usuario.getText();
    }


    public String getClave() {
        return claveField.getText().trim();
    }

}