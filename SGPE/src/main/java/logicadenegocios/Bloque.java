
package logicadenegocios;

import java.util.ArrayList;

/**
 *
 * @author pablo Luis Aaron
 */
public class Bloque {
  protected String idCurso;
  protected String numPlan;
  protected int numBloque;
  private ArrayList<String> idCursos;
  
  /**
   * 
   * @param pIdCurso
   * @param pNumPlan
   * @param pNumBloque 
   */
  public Bloque(String pIdCurso, String pNumPlan, int pNumBloque) {
    this.idCurso = pIdCurso;
    this.numPlan = pNumPlan;
    this.numBloque = pNumBloque;
    this.idCursos.add(idCurso);
  }
  
  public Bloque(String pIdCurso, String pNumPlan) {
    this.idCurso = pIdCurso;
    this.numPlan = pNumPlan;
  }

  /**
   * 
   * @return 
   */
  public String getIdCurso() {
    return idCurso;
  }

  /**
   * 
   * @param idCurso 
   */
  public void setIdCurso(String pIdCurso) {
    this.idCurso = pIdCurso;
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
   * @param numPlan 
   */
  public void setNumPlan(String pNumPlan) {
    this.numPlan = pNumPlan;
  }

  /**
   * 
   * @return 
   */
  public int getNumBloque() {
    return numBloque;
  }

  /**
   * 
   * @param numBloque 
   */
  public void setNumBloque(int pNumBloque) {
    this.numBloque = pNumBloque;
  }

  /**
   * 
   * @return 
   */
  public ArrayList<String> getIdCursos() {
    return idCursos;
  }

  /**
   * 
   * @param idCursos 
   */
  public void setIdCursos(ArrayList<String> idCursos) {
    this.idCursos = idCursos;
  }
  
  
}
