/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

/**
 * Abstracción de la clase PlandeEscuela
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class PlandeEscuela {
  protected String idEscuela;
  protected String numPlan;

  /**
   * Constructor de la clase PlandeEscuela
   * @param pIdEscuela de tipo String
   * @param pNumPlan de tipo String
   */
 public PlandeEscuela(String pIdEscuela, String pNumPlan) {
   this.idEscuela = pIdEscuela;
   this.numPlan = pNumPlan;
 }

 
 public String getIdEscuela() {
   return idEscuela;
  }

 
 public void setIdEscuela(String pIdEscuela) {
   this.idEscuela = pIdEscuela;
  }

  
  public String getNumPlan() {
    return numPlan;
  }

  
  public void setNumPlan(String pNumPlan) {
    this.numPlan = pNumPlan;
  }
  
  
}
