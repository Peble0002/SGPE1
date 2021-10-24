/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import logicadenegocios.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * Abstracción de la clase CursoCorrequisitosBD
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class CursoCorrequisitosBD {
  Conexion conexion = new Conexion();
  
  /**
   * Método para consultar los correquisitos de un curso
   * @param pCurso de tipo curso
   * @return ResultSet con toda la información de los cursos y sus correquisitos
   */
  public ResultSet consultarCorrequisitos(Curso pCurso){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Correquisitos_Curso.IDCursoCorrequisito,"
              + " Curso.Nombre FROM Correquisitos_Curso, "
              + "Curso WHERE Correquisitos_Curso.IDCursoConsultado = '" 
              + pCurso.getIdCursos() 
              + "' AND Correquisitos_Curso.IDCursoCorrequisito = Curso.IDCurso");
      rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  /**
   * Método para verificar si existe un requisito de un curso
   * @param pCursoConsulta de tipo curso
   * @param pCursoRequisito de tipo curso
   * @return boolean, en donde retorna false si no existe 
   */
  public boolean existeRequisito(Curso pCursoConsulta, Curso pCursoRequisito){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT * FROM Correquisitos_Curso WHERE "
              + "Correquisitos_Curso.IDCursoConsultado = '" 
              + pCursoConsulta.getIdCursos() + "' AND Correquisitos_Curso.IDCursoCorrequisito = '" 
              + pCursoRequisito.getIdCursos() + "'");
      rs = ps.executeQuery();
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
  
  /**
   * Método para eliminar un requisito de un curso
   * @param pCursoConsulta de tipo curso
   * @param pCursoRequisito de tipo curso
   */
  public void eliminarRequisito(Curso pCursoConsulta, Curso pCursoRequisito){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("DELETE FROM "
              + "Requisitos_Curso WHERE Correquisitos_Curso.IDCursoConsultado = "
              + "? AND Correquisitos_Curso.IDCursoCorrequisito = ?");
      ps.setString(1, pCursoConsulta.getIdCursos());
      ps.setString(2, pCursoRequisito.getIdCursos());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Eliminación completada.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * Método para registrar los correquisitos de un curso
   * @param pCursoConsulta Curso que se consulta
   * @param pCursoCorrequisito correquisitos del curso 
   */
  public void registrarCorrequisito(Curso pCursoConsulta, Curso pCursoCorrequisito){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Correquisitos_"
              + "Curso VALUES (?, ?)");
      ps.setString(1, pCursoConsulta.getIdCursos());
      ps.setString(2, pCursoCorrequisito.getIdCursos());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro guardado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * Método para verificar si existe un correquisito de un curso
   * @param pCursoConsulta Curso que se consulta
   * @param pCursoCorrequisito correquisitos del curso
   * @return boolean, retorna false si no existe el correquisito
   */
  public boolean existeCorrequisito(Curso pCursoConsulta, Curso pCursoCorrequisito){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT * FROM Correquisitos_Curso WHERE "
              + "Correquisitos_Curso.IDCursoConsultado = '" 
              + pCursoConsulta.getIdCursos() + "' AND Correquisitos_Curso."
              + "IDCursoCorrequisito = '"+pCursoCorrequisito.getIdCursos()+"'");
      rs = ps.executeQuery();
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
}
