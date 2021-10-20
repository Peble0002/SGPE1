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
 *
 * @author Aarón Soto
 */
public class Escuela_PlanEstudioBD {
  Conexion conexion = new Conexion();
  
  public boolean existePlan(String pEscuela, String pCodigo){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT EscuelaOArea.Nombre, Escuela_PlanEstudio.NumeroPlan FROM EscuelaOArea, Escuela_PlanEstudio WHERE EscuelaOArea.Nombre = '" + pEscuela + "' AND Escuela_PlanEstudio.NumeroPlan = " + pCodigo);
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs.getRow() == 0;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
  
  public ResultSet consultarEscuelaPlan(){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Nombre, NumeroPlan FROM EscuelaOArea, Escuela_PlanEstudio WHERE EscuelaOArea.IDEscuela = Escuela_PlanEstudio.IDEscuela");
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
}
