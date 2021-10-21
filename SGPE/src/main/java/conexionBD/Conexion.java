/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo aaron & Luis
 */
public class Conexion {
  Connection conectar = null;
  String usuario = "admin";
  String contrasena = "sql123";
  String cadenaBase = "jdbc:sqlserver://localhost:1433/SGPE";
  
  public Conexion(){
  }
  
  /**
   * 
   * @return 
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
