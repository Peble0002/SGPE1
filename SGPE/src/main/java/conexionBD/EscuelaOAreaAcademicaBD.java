/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import logicadenegocios.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Abstracción de la clase EscuelaOAreaAcademicaBD
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class EscuelaOAreaAcademicaBD {
  Conexion conexion = new Conexion();
  //EscuelaOAreaAcademica escuela = null;
  
  public EscuelaOAreaAcademicaBD() {
  }
  
  /**
   * Método para insertar una escuela
   * @param pEscuela de tipo EscuelaOAreaAcademica
   */
  public void insertarEscuela(EscuelaOAreaAcademica pEscuela){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO EscuelaOArea "
              + "(IDEscuela, Nombre) VALUES (?,?)");
      ps.setString(1, pEscuela.getCodigo());
      ps.setString(2, pEscuela.getNombre());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro guardado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * Método para consultar escuelas 
   * @return ResultSet con toda la información de las escuelas
   */
  public ResultSet consultarEscuelas(){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT * FROM EscuelaOArea");
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  /**
   * Método para obtener el código de la escuela
   * @param pNombreEscuela de tipo String
   * @return un string con el código de la escuela
   */
  public String obtenerCodigoEscuela(String pNombreEscuela){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT IDEscuela FROM EscuelaOArea "
              + "WHERE Nombre = " + pNombreEscuela);
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs.getString(1); //Siempre devolverá un valor al haber sido comprobado que existía.
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
}
