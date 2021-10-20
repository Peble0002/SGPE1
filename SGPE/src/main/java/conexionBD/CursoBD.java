/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import logicadenegocios.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Aarón Soto
 */
public class CursoBD {
  Conexion conexion = new Conexion();
  
  public void insertarCurso(Curso pCurso){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Curso (IDCurso, Nombre, Creditos, Horas_Lectivas) VALUES (?,?,?,?)");
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
}
