/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import java.sql.*;
import javax.swing.JOptionPane;
import logicadenegocios.*;

/**
 *
 * @author Aarón Soto
 */
public class Curso_PlanEstudioBD {
  Conexion conexion = new Conexion();
  
  
  public void insertarCursoPlanEstudio(Bloque pCursoPlan){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO PlanEstudio_Curso (IDCurso, NumeroPlan, NumeroBloque) VALUES (?,?,?)");
      ps.setString(1, pCursoPlan.getIdCurso());
      ps.setString(2, pCursoPlan.getNumPlan());
      ps.setInt(3, pCursoPlan.getNumBloque());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro guardado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  public void eliminarCursoPlan(Bloque pBloque){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("DELETE FROM PlanEstudio_Curso WHERE IDCurso = ? AND NumeroPlan = ?");
      ps.setString(1, pBloque.getIdCurso());
      ps.setString(2, pBloque.getNumPlan());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Eliminación completada.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  public ResultSet consultarPlanesEstudioCurso(Curso pCurso){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT EscuelaOArea.IDEscuela, EscuelaOArea.Nombre, PlanEstudio_Curso.NumeroPlan FROM EscuelaOArea, Escuela_PlanEstudio, PlanEstudio_Curso WHERE PlanEstudio_Curso.IDCurso = '" + pCurso.getIdCursos() + "' AND PlanEstudio_Curso.NumeroPlan = Escuela_PlanEstudio.NumeroPlan AND Escuela_PlanEstudio.IDEscuela = EscuelaOArea.IDEscuela;");
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
}
