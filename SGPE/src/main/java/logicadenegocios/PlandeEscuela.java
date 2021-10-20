/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

/**
 *
 * @author pablo
 */
public class PlandeEscuela {
  protected String idEscuela;
  protected String numPlan;

  /**
   * 
   * @param pIdEscuela
   * @param pNumPlan 
   */
  public PlandeEscuela(String pIdEscuela, String pNumPlan) {
    this.idEscuela = pIdEscuela;
    this.numPlan = pNumPlan;
  }

  /**
   * 
   * @return 
   */
  public String getIdEscuela() {
    return idEscuela;
  }

  /**
   * 
   * @param pIdEscuela 
   */
  public void setIdEscuela(String pIdEscuela) {
    this.idEscuela = pIdEscuela;
  }

  /**
   * 
   * @return 
   */
  public String getNumPlan() {
    return numPlan;
  }

  /**
   * 
   * @param pNumPlan 
   */
  public void setNumPlan(String pNumPlan) {
    this.numPlan = pNumPlan;
  }
  
  
}
