/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import logicadenegocios.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * Abstracción de la clase CursoRequisitosBD
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class CursoRequisitosBD {
  Conexion conexion = new Conexion();
  
  /**
   * Método para consultar los requisitos de un curso
   * @param pCurso de tipo curso
   * @return ResultSet con la información del curso y sus requisitos
   */
  public ResultSet consultarRequisitos(Curso pCurso){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Requisitos_Curso.IDCursoRequisito, Curso.Nombre FROM Requisitos_Curso, Curso WHERE Requisitos_Curso.IDCursoConsultado = '" + pCurso.getIdCursos() + "' AND Requisitos_Curso.IDCursoRequisito = Curso.IDCurso");
      rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  /**
   * Método para verificar si existe un requisito asociado a un curso
   * @param pCursoConsulta de tipo curso
   * @param pCursoRequisito de tipo curso
   * @return boolean, donde el false significa que no existe ese requisito
   */
  public boolean existeRequisito(Curso pCursoConsulta, Curso pCursoRequisito){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT * FROM Requisitos_Curso WHERE "
              + "Requisitos_Curso.IDCursoConsultado = '" 
              + pCursoConsulta.getIdCursos() + "' AND Requisitos_Curso.IDCursoRequisito "
                      + "= '" + pCursoRequisito.getIdCursos() + "'");
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
      PreparedStatement ps = con.prepareStatement("DELETE FROM Requisitos_Curso"
              + " WHERE Requisitos_Curso.IDCursoConsultado = ? "
              + "AND Requisitos_Curso.IDCursoRequisito = ?");
      ps.setString(1, pCursoConsulta.getIdCursos());
      ps.setString(2, pCursoRequisito.getIdCursos());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Eliminación completada.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * Método para registrar un requisito a un curso
   * @param pCursoConsulta de tipo curso
   * @param pCursoRequisito de tipo curso
   */
  public void registrarRequisito(Curso pCursoConsulta, Curso pCursoRequisito){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Requisitos_Curso"
              + " VALUES (?, ?)");
      ps.setString(1, pCursoConsulta.getIdCursos());
      ps.setString(2, pCursoRequisito.getIdCursos());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro guardado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}
