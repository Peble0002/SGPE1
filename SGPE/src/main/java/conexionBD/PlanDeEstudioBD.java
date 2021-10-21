/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import logicadenegocios.*;
import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
/**
 *
 * @author Pablo Luis Aarón 
 */
public class PlanDeEstudioBD {
  Conexion conexion = new Conexion();
  
  /**
   * 
   * @param pCodigo
   * @return 
   */
  public ResultSet consultarPlanEstudio(String pCodigo){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Curso.IDCurso, Nombre, NumeroBloque,"
              + " Horas_Lectivas, Creditos FROM Curso, PlanEstudio_Curso "
              + "WHERE PlanEstudio_Curso.NumeroPlan = " + pCodigo 
              + " AND Curso.IDCurso = PlanEstudio_Curso.IDCurso ORDER "
                      + "BY(NumeroBloque)");
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  /**
   * 
   * @param pCodigoPlan
   * @return 
   */
  public LocalDate obtenerFechaVigencia(String pCodigoPlan){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT FechaEntradaVigencia FROM "
              + "PlanEstudio WHERE NumeroPlan = ?");
      ps.setString(1, pCodigoPlan);
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      Date fecha = rs.getDate(1); //Siempre devolverá un valor al haber sido comprobado que existía.
      LocalDate vigencia = fecha.toLocalDate();
      return vigencia;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  public String obtenerStringFechaVigencia(LocalDate pFecha){
    DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy/MM/DD");
    String fecha = pFecha.format(FORMATO);
    return fecha;
  }
  
  /**
   * 
   * @param pPlan 
   */
  public void insertarPlan(PlanDeEstudio pPlan){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO PlanEstudio "
              + "(NumeroPlan, FechaEntradaVigencia) VALUES (?,?)");
      ps.setString(1, pPlan.getNumPlan());
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
      String formattedString = pPlan.getNumPlan().formatted(formatter);
      ps.setString(2, formattedString);
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro guardado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
}
