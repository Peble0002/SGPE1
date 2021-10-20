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
}
