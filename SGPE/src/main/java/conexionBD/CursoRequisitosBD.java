/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import logicadenegocios.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Pablo Luis Aarón 
 */
public class CursoRequisitosBD {
  Conexion conexion = new Conexion();
  
  /**
   * 
   * @param pCurso
   * @return 
   */
  public ResultSet consultarRequisitos(Curso pCurso){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Requisitos_Curso.IDCursoRequisito, Curso.Nombre FROM Requisitos_Curso, Curso WHERE Requisitos_Curso.IDCursoConsultado = '" + pCurso.getIdCursos() + "' AND Requisitos_Curso.IDCursoRequisito = Curso.IDCurso");
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
   * @param pCursoConsulta
   * @param pCursoRequisito
   * @return 
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
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
  
  /**
   * 
   * @param pCursoConsulta
   * @param pCursoRequisito 
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
