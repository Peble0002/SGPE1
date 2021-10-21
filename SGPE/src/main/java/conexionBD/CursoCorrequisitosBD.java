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
 * @author Pablo Luis Aaron
 */
public class CursoCorrequisitosBD {
  Conexion conexion = new Conexion();
  
  public ResultSet consultarPlanesEstudioCurso(Curso pCurso){
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
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
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
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
  
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
}
