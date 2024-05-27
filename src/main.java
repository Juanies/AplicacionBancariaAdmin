import controlador.DashboardController;
import controlador.loginControaldor;
import vista.Dashboard;
import vista.LoginForm;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new DashboardController(new Dashboard());
    }
}
