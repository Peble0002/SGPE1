/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import logicadenegocios.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Abstracción de la clase CursoBD
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class CursoBD {
  Conexion conexion = new Conexion();
  
  /**
   * Método para insertar un curso en la base de datos
   * @param pCurso de tipo curso
   */
  public void insertarCurso(Curso pCurso){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Curso (IDCurso, "
              + "Nombre, Creditos, Horas_Lectivas) VALUES (?,?,?,?)");
      ps.setString(1, pCurso.getIdCursos());
      ps.setString(2, pCurso.getNombre());
      ps.setInt(3, pCurso.getCreditos());
      ps.setInt(4, pCurso.getHorasLectivas());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro completado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * Método para verificar si existe un curso en la base de datos
   * @param pCurso de tipo curso
   * @return un boolean, retorna false si no existe
   */
  public boolean existeCurso(Curso pCurso){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM Curso WHERE "
              + "Curso.IDCurso = '" + pCurso.getIdCursos() + "'");
      rs = ps.executeQuery();
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
  
  /**
   * Método para determinar si existe un curso en el plan de estudios
   * @param pCurso de tipo curso 
   * @return un boolean, retorna false si no existe
   */
  public boolean existeCursoEnPlan(Curso pCurso){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM PlanEstudio_" +
              "Curso WHERE PlanEstudio_Curso.IDCurso = '" + pCurso.getIdCursos()
              + "'");
      rs = ps.executeQuery();
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
  
  /**
   * Método para eliminar un curso de la base de datos 
   * @param pCurso de tipo curso
   */
  public void eliminarCurso(Curso pCurso){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("DELETE FROM PlanEstudio_"
              + "Curso WHERE PlanEstudio_Curso.IDCurso = ?");
      ps.setString(1, pCurso.getIdCursos());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Eliminación completada.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}
