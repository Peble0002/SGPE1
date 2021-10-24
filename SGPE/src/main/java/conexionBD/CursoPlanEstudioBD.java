/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import java.sql.*;
import javax.swing.JOptionPane;
import logicadenegocios.*;

/**
 * Abstracción de la clase CursoPlanEstudioBD
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class CursoPlanEstudioBD {
  Conexion conexion = new Conexion();
  
  /**
   * Método para insertar un curso a un plan de estudio
   * @param pCursoPlan de tipo bloque
   */
  public void insertarCursoPlanEstudio(Bloque pCursoPlan){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO PlanEstudio_Curso "
              + "(IDCurso, NumeroPlan, NumeroBloque) VALUES (?,?,?)");
      ps.setString(1, pCursoPlan.getIdCurso());
      ps.setString(2, pCursoPlan.getNumPlan());
      ps.setInt(3, pCursoPlan.getNumBloque());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro guardado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * Método para eliminar un curso de un plan de estudio
   * @param pBloque de tipo Bloque
   */
  public void eliminarCursoPlan(Bloque pBloque){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("DELETE FROM PlanEstudio_Curso "
              + "WHERE IDCurso = ? AND NumeroPlan = ?");
      ps.setString(1, pBloque.getIdCurso());
      ps.setString(2, pBloque.getNumPlan());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Eliminación completada.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * Método para consultar plan de estudios con un curso en particular
   * @param pCurso de tipo curso
   * @return ResultSet con todos los datos del plan de estudio
   */
  public ResultSet consultarPlanesEstudioCurso(Curso pCurso){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT EscuelaOArea.IDEscuela, EscuelaOArea.Nombre, "
              + "PlanEstudio_Curso.NumeroPlan FROM EscuelaOArea, Escuela_PlanEstudio, "
              + "PlanEstudio_Curso WHERE PlanEstudio_Curso.IDCurso = '" 
              + pCurso.getIdCursos() + "' AND PlanEstudio_Curso.NumeroPlan = "
              + "Escuela_PlanEstudio.NumeroPlan AND Escuela_PlanEstudio.IDEscuela "
              + "= EscuelaOArea.IDEscuela;");
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  /**
   * Método para verificar si existe un curso en la base de datos
   * @param pBloque de tipo curso
   * @return un boolean, retorna false si no existe
   */
  public boolean existeCurso(Bloque pBloque){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM Curso WHERE "
              + "Curso.IDCurso = '" + pBloque.getIdCurso() + "'");
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
  
  /**
   * Método para verificar si existe un curso en la base de datos
   * @param pBloque de tipo curso
   * @return un boolean, retorna false si no existe
   */
  public boolean existeCursoEnPlan(Bloque pBloque){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM PlanEstudio_" 
              + "Curso WHERE PlanEstudio_Curso.IDCurso = '" + pBloque.getIdCurso() 
              + "' AND PlanEstudio_Curso.NumeroPlan = '" + pBloque.getNumPlan() 
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
