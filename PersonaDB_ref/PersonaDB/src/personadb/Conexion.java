package personadb;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    protected Connection cnn;
    protected void Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mascotas", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void Desconectar() {
        try {
            cnn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
