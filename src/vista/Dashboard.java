package vista;


import programa.Financiacion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard extends JFrame {
    public JPanel financiacionPanel;

    public HashMap<String, Financiacion> botonFinanciacionMap = new HashMap<>();
    public ArrayList<JButton> botonesAceptar = new ArrayList<>();
    public ArrayList<JButton> botoncesRechazar = new ArrayList<>();

    public Dashboard() {
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Santander");
        setLayout(new BorderLayout());


        financiacionPanel = new JPanel();
        financiacionPanel.setLayout(new BoxLayout(financiacionPanel, BoxLayout.Y_AXIS));
        financiacionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(financiacionPanel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public void setFinanciacion(ArrayList<Financiacion> financiaciones) {
        financiacionPanel.removeAll();
        for (Financiacion financiacion : financiaciones) {
            JPanel financiacionItem = new JPanel(new BorderLayout());
            financiacionItem.setBorder(new EmptyBorder(10, 40, 10, 10));
            financiacionItem.setBackground(new Color(255, 255, 255));
            financiacionItem.setMaximumSize(new Dimension(900, 130));



            JPanel financiacionInfoPanel = new JPanel();
            financiacionInfoPanel.setLayout(new BoxLayout(financiacionInfoPanel, BoxLayout.Y_AXIS));
            financiacionInfoPanel.setOpaque(false);

            JLabel financiacionLabel = new JLabel(financiacion.getMotivo());

            JLabel financiacionIdLabel = new JLabel("ID: " + financiacion.getId());

            JLabel financiacionMontoLabel = new JLabel("Cantidad: " + financiacion.getCantidad() + " EUR");
            financiacionMontoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

            financiacionInfoPanel.add(financiacionLabel);
            financiacionInfoPanel.add(financiacionIdLabel);
            financiacionInfoPanel.add(financiacionMontoLabel);

            JButton aceptarButton = new JButton("Aceptar");
            JButton denegarButton = new JButton("Denegar");

            botonesAceptar.add(aceptarButton);
            botoncesRechazar.add(denegarButton);

            //Uso HashMap para saber que boton pertenece a que financiacion

            aceptarButton.setName("aceptarButton-" + financiacion.getId());
            denegarButton.setName("denegarButton-" + financiacion.getId());

            botonFinanciacionMap.put(aceptarButton.getName(), financiacion);
            botonFinanciacionMap.put(denegarButton.getName(), financiacion);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.add(aceptarButton);
            buttonPanel.add(denegarButton);

            financiacionItem.add(financiacionInfoPanel, BorderLayout.CENTER);
            financiacionItem.add(buttonPanel, BorderLayout.SOUTH);

            financiacionPanel.add(financiacionItem);
        }
        revalidate();
        repaint();
    }


}
