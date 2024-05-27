package programa;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AdminDAO{



    public static ArrayList<Admin> obtenerTodosLosUsuarios(Connection con) throws SQLException {
        ArrayList<Admin> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM admin";
        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Admin admin = new Admin(
                        rs.getInt("id"),
                        rs.getString("usuario"),
                        rs.getString("clave")
                );
                usuarios.add(admin);
            }
        }
        return usuarios;
    }


}