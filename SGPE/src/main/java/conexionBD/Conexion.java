
package conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Abstracción de la clase Conexion
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (24/10/2021)
 */
public class Conexion {
  Connection conectar = null;
  String usuario = "admin";
  String contrasena = "sql123";
  String cadenaBase = "jdbc:sqlserver://localhost:1433/SGPE";
  
  /**
   * Método constructor conexion
   */
  public Conexion(){
  }
  
  /**
   * Método para obtener la conexión con la base de datos
   * @return el driver con la conexión a la base de datos
   */
  public Connection getConexion(){
    String conexionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SGPE";
    
    try{
      conectar = DriverManager.getConnection(conexionUrl, usuario, contrasena);
      JOptionPane.showMessageDialog(null, "Se conectó exitosamente a la base de datos.");
      return conectar;
    }catch(SQLException e){
      System.out.println("Error detectado.");
      System.out.println(e.toString());
      return null;
    }
  }
}
