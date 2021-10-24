/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;
import logicadenegocios.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * Abstracción de la clase EscuelaPlanEstudioBD
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class EscuelaPlanEstudioBD {
  Conexion conexion = new Conexion();
  
  /**
   * Método para verificar si existe un plan de estudios en una escuela
   * @param pEscuela de tipo String
   * @param pCodigo de tipo String
   * @return boolean, donde el false significa que no existe el plan de estudios
   */
  public boolean existePlan(String pEscuela, String pCodigo){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT EscuelaOArea.Nombre, "
              + "Escuela_PlanEstudio.NumeroPlan FROM EscuelaOArea, "
              + "Escuela_PlanEstudio WHERE EscuelaOArea.Nombre = '" 
              + pEscuela + "' AND Escuela_PlanEstudio.NumeroPlan = " + pCodigo);
      rs = ps.executeQuery();
      return rs.getRow() == 0;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return false;
    }
  }
  
  /**
   * Método para consultar la información de las escuelas y planes de estudio
   * @return ResultSet con la información de las escuelas y planes de estudio
   */
  public ResultSet consultarEscuelaPlan(){
    PreparedStatement ps;
    ResultSet rs;
    
    try{
      Connection con = conexion.getConexion();
      ps = con.prepareStatement("SELECT Nombre, NumeroPlan FROM EscuelaOArea,"
              + " Escuela_PlanEstudio WHERE EscuelaOArea.IDEscuela = "
              + "Escuela_PlanEstudio.IDEscuela");
      rs = ps.executeQuery();
      return rs;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
      return null;
    }
  }
  
  /**
   * Método para insertar un plan de estudios
   * @param pPlanEscuela de tipo PlanDeEstudio
   */
  public void insertarEscuelaPlan(PlandeEscuela pPlanEscuela){
    try{
      Connection con = conexion.getConexion();
      PreparedStatement ps = con.prepareStatement("INSERT INTO Escuela_PlanEs" +
              "tudio (IDEscuela, NumeroPlan) VALUES (?,?)");
      ps.setString(1, pPlanEscuela.getIdEscuela());
      ps.setString(2, pPlanEscuela.getNumPlan());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Registro guardado.");
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null, e.toString());
    }
  }
}
