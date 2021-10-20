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
public class PlanDeEstudioBD {
  Conexion conexion = new Conexion();
  
  public ResultSet consultarPlanEstudio(String pCodigo){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Curso.IDCurso, Nombre, NumeroBloque, Horas_Lectivas, Creditos FROM Curso, PlanEstudio_Curso WHERE PlanEstudio_Curso.NumeroPlan = " + pCodigo + " AND Curso.IDCurso = PlanEstudio_Curso.IDCurso ORDER BY(NumeroBloque)");
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  public Date obtenerFechaVigencia(String pCodigoPlan){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT FechaEntradaVigencia FROM PlanEstudio WHERE NumeroPlan = ?");
      ps.setString(1, pCodigoPlan);
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs.getDate(1); //Siempre devolverá un valor al haber sido comprobado que existía.
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
}
