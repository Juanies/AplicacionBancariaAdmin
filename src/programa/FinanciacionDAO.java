package programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FinanciacionDAO {


    public static ArrayList<Financiacion> cogerTodasFinanciacionCuentas(Connection con) {
        ArrayList<Financiacion> financiaciones = new ArrayList<>();


            String sql = "SELECT * FROM financiacion WHERE rechazado = 0";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int financiacionID = rs.getInt("id");
                    int cuentaid = rs.getInt("cuentaID");
                    double cantidadFinanciacion = rs.getDouble("cantidad");
                    String motivoFinanciacion = rs.getString("motivo");
                    Boolean estaAceptado = rs.getBoolean("aceptado");
                    Boolean estaRechazado = rs.getBoolean("rechazado");

                    Financiacion financiacion = new Financiacion(financiacionID, cuentaid, cantidadFinanciacion, motivoFinanciacion, estaAceptado, estaRechazado);
                    if (!financiacion.getAceptado()) {
                        financiaciones.add(financiacion);
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        return financiaciones;
    }

    public static void aceptadoORechazado(Financiacion financiacion, Boolean tipo,  Connection con) throws SQLException {
        String sql = "UPDATE financiacion SET aceptado = ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setBoolean(1, tipo);
            stmt.setInt(2, financiacion.getId());
            stmt.executeUpdate();
        }
    }

    public static void rechazado(Financiacion financiacion, Boolean tipo,  Connection con) throws SQLException {
        String sql = "UPDATE financiacion SET rechazado = ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setBoolean(1, tipo);
            stmt.setInt(2, financiacion.getId());
            stmt.executeUpdate();
        }
    }





}