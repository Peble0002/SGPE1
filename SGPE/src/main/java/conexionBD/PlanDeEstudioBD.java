/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import logicadenegocios.*;
import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 * Abstracción de la clase PlanDeEstudioBD
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class PlanDeEstudioBD {
  Conexion conexion = new Conexion();
  
  /**
   * Método para consultar planes de estudio
   * @param pCodigo de tipo String
   * @return un ResultSet con la información de los planes de estudio
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
   * Método para obtener la fecha de vigencia del plan de estudio
   * @param pCodigoPlan de tipo String
   * @return un String con la fecha de vigencia
   */
  public String obtenerFechaVigencia(String pCodigoPlan){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement ("SELECT * FROM PlanEstudio WHERE NumeroPlan = ?");
      ps.setString(1, pCodigoPlan);
      rs = ps.executeQuery();
      String vigencia = rs.getString("FechaEntradaVigencia");
      
//      Date fecha = rs.getDate("FechaEntradaVigencia"); //Siempre devolverá un valor al haber sido comprobado que existía.
//      LocalDate vigencia = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      return vigencia;
    }catch(SQLException e){
      System.out.print("ss");
      return null;
    }
  }
  
  /**
   * Método para obtener el string de la fecha de vigencia
   * @param pFecha de tipo LocalDate
   * @return String con la fecha de vigencia
   */
  public String obtenerStringFechaVigencia(LocalDate pFecha){
    DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy/MM/DD");
    String fecha = pFecha.format(FORMATO);
    return fecha;
  }
  
  /**
   * Método para insertar un plan de estudios
   * @param pPlan de tipo PlanDeEstudio
   */
  public void insertarPlan(PlanDeEstudio pPlan){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO PlanEstudio "
              + "(NumeroPlan, FechaEntradaVigencia) VALUES (?,?)");
      ps.setString(1, pPlan.getNumPlan());
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy mm dd");
      String formattedString = pPlan.getNumPlan().formatted(formatter);
      ps.setString(2, formattedString);
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro guardado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * Método para verificar si existe un curso en la base de datos
   * @param pPlanEstudio de tipo curso
   * @return un boolean, retorna false si no existe
   */
  public boolean existePlanEstudio(PlanDeEstudio pPlanEstudio){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM PlanEstudio "
              + "WHERE PlanEstudio.NumeroPlan = '" + pPlanEstudio.getNumPlan()
              + "'");
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
  
}
