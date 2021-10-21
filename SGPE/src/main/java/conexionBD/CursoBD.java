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
 * @author pablo Luis Aarón 
 */
public class CursoBD {
  Conexion conexion = new Conexion();
  
  /**
   * 
   * @param pCurso 
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
      JOptionPane.showMessageDialog(null, "Registro guardado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
  
  /**
   * 
   * @param pCurso
   * @return 
   */
  public boolean existeCurso(Curso pCurso){
    ResultSet rs;
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM Curso WHERE "
              + "Curso.IDCurso = '" + pCurso.getIdCursos() + "'");
      rs = ps.executeQuery();
      JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente.");
      return rs.next();
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
}
