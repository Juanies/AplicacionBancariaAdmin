package programa;

import java.util.Calendar;
import java.util.Date;


public class Admin{

    private int id;
    private String usuario;
    private String clave;

    public int getId() {
        return id;
    }


    public Admin(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public Admin(int id, String usuario, String clave) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


}