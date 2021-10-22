
package logicadenegocios;

import java.util.ArrayList;

/**
 * Abstracción de la clase Bloque
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class Bloque {
  protected String idCurso;
  protected String numPlan;
  protected int numBloque;
  private ArrayList<String> idCursos;
  
  /**
   * Constructor de la clase Bloque
   * @param pIdCurso de tipo String
   * @param pNumPlan de tipo String
   * @param pNumBloque de tipo int
   */
  public Bloque(String pIdCurso, String pNumPlan, int pNumBloque) {
    this.idCursos = new ArrayList<String>();
    this.idCurso = pIdCurso;
    this.numPlan = pNumPlan;
    this.numBloque = pNumBloque;
    this.idCursos.add(pIdCurso);
  }
  
  /**
   * Constructor de la clase Bloque
   * @param pIdCurso de tipo String
   * @param pNumPlan de tipo String
   */
  public Bloque(String pIdCurso, String pNumPlan) {
    this.idCurso = pIdCurso;
    this.numPlan = pNumPlan;
  }

  
  public String getIdCurso() {
    return idCurso;
  }

 
  public void setIdCurso(String pIdCurso) {
    this.idCurso = pIdCurso;
  }

 
  public String getNumPlan() {
    return numPlan;
  }

  
  public void setNumPlan(String pNumPlan) {
    this.numPlan = pNumPlan;
  }


  public int getNumBloque() {
    return numBloque;
  }

  
  public void setNumBloque(int pNumBloque) {
    this.numBloque = pNumBloque;
  }

  
  public ArrayList<String> getIdCursos() {
    return idCursos;
  }

  
  public void setIdCursos(ArrayList<String> idCursos) {
    this.idCursos = idCursos;
  }
  
  
}
