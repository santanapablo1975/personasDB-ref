package personadb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class PersonaAdmin extends Conexion{    
    public List<PersonaModel>Consultar(){
        List<PersonaModel>lista=new ArrayList<>();
        Conectar();
        try {
            PreparedStatement sentencia=cnn.prepareCall("CALL `ConsultarPersona`()");
            ResultSet resultado=sentencia.executeQuery();
            while (resultado.next()) {                
                PersonaModel modelo=new PersonaModel();
                modelo.setIdpersona(resultado.getInt(1));
                modelo.setNombre(resultado.getString(2));
                modelo.setApellido(resultado.getString(3));
                lista.add(modelo);
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
        Desconectar();
        }
        return lista;
    }
    public void Guardar(PersonaModel modelo){
        Conectar();
        try {
            PreparedStatement sentencia=cnn.prepareCall("CALL `InsertarPersona`(?,?)");
            sentencia.setString(1, modelo.getNombre());
            sentencia.setString(2, modelo.getApellido());
            int resultado=sentencia.executeUpdate();
            if (resultado==1) {
                JOptionPane.showMessageDialog(new JFrame(), "Persona Guardada");
            }else{
               JOptionPane.showMessageDialog(new JFrame(), "Persona NO Guardada");
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
        Desconectar();
        }
    }
    public void Actualizar(PersonaModel modelo){
        Conectar();
        try {
            PreparedStatement sentencia=cnn.prepareCall("CALL `ActualizarPersona`(?,?,?)");
            sentencia.setInt(1, modelo.getIdpersona());
            sentencia.setString(2, modelo.getNombre());
            sentencia.setString(3, modelo.getApellido());
            int resultado=sentencia.executeUpdate();
            if (resultado==1) {
                JOptionPane.showMessageDialog(new JFrame(), "Persona Actualizada");
            }else{
               JOptionPane.showMessageDialog(new JFrame(), "Persona NO Actualizada");
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
        Desconectar();
        }
    }
    public void Eliminar(PersonaModel modelo){
        Conectar();
        try {
            PreparedStatement sentencia=cnn.prepareCall("CALL `EliminarPersona`(?)");
            sentencia.setInt(1, modelo.getIdpersona());
            int resultado=sentencia.executeUpdate();
            if (resultado==1) {
                JOptionPane.showMessageDialog(new JFrame(), "Persona Eliminada");
            }else{
               JOptionPane.showMessageDialog(new JFrame(), "Persona NO Eliminada");
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
        Desconectar();
        }
    }
}
