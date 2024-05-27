package controlador;


import programa.Admin;
import programa.AdminDAO;
import programa.Util;
import vista.LoginForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class loginControaldor implements ActionListener {
    private LoginForm vista;

    public loginControaldor(LoginForm visita){
        this.vista = visita;
        visita.entrar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Entrar":
                try {
                    loginForm();
                } catch (SQLException | IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }
    }

    public void loginForm() throws SQLException, IOException, ClassNotFoundException {

        ArrayList<Admin> admins = AdminDAO.obtenerTodosLosUsuarios(Util.con());

        for(Admin admin : admins){
            String usuarioUsuario = admin.getUsuario();
            String claveUsuario = admin.getClave();

            String usuario = vista.getusuario();
            String clave = vista.getClave();

            if (usuario.equals(usuarioUsuario) && clave.equals(claveUsuario)){
                System.out.println("Inicio correcto");
            }else{
                JOptionPane.showMessageDialog(null, "Error", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }
        }

    }


}