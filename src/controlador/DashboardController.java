package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import programa.Financiacion;
import programa.FinanciacionDAO;
import programa.Usuario;
import programa.Util;
import vista.Dashboard;

public class DashboardController implements ActionListener {
    private Dashboard vista;

    public DashboardController(Dashboard vista) {
        this.vista = vista;
        vista.setFinanciacion(FinanciacionDAO.cogerTodasFinanciacionCuentas(Util.con()));

        for (JButton boton : vista.botonesAceptar) {
            boton.addActionListener(this);
        }

        for (JButton boton : vista.botoncesRechazar) {
            boton.addActionListener(this);
        }


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        Financiacion financiacion = getFinanciacionFromButton(boton);

        if (boton.getText().equals("Aceptar")) {
            try {
                FinanciacionDAO.aceptadoORechazado(financiacion, true, Util.con());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (boton.getText().equals("Denegar")) {
            try {
                FinanciacionDAO.rechazado(financiacion, true, Util.con());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
    public Financiacion getFinanciacionFromButton(JButton button) {
        String botonName = button.getName();
        Financiacion financiacion = vista.botonFinanciacionMap.get(botonName);
        return financiacion;
    }

}
