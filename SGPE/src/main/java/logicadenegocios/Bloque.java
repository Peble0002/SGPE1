
package logicadenegocios;

import java.util.ArrayList;

/**
 * Abstracción de la clase Bloque
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class Bloque {
  /**
   * atributos de la clase bloque
   */
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

  
  /**
   * 
   * @return id del curso
   */
  public String getIdCurso() {
    return idCurso;
  }

 
  /** 
   * 
   * @param pIdCurso id del curso
   */
  public void setIdCurso(String pIdCurso) {
    this.idCurso = pIdCurso;
  }

 
  /**
   * 
   * @return el numero de pla
   */
  public String getNumPlan() {
    return numPlan;
  }

  
  /**
   * 
   * @param pNumPlan asigna el numero de plan
   */
  public void setNumPlan(String pNumPlan) {
    this.numPlan = pNumPlan;
  }


  /**
   * 
   * @return numero del bloque
   */
  public int getNumBloque() {
    return numBloque;
  }

  /**
   * 
   * @param pNumBloque asigan número de bloque
   */
  public void setNumBloque(int pNumBloque) {
    this.numBloque = pNumBloque;
  }

  /**
   * 
   * @return  lista cons los id de los cursos
   */
  public ArrayList<String> getIdCursos() {
    return idCursos;
  }

  /**
   * 
   * @param idCursos asigna el id de lps cursos
   */
  public void setIdCursos(ArrayList<String> idCursos) {
    this.idCursos = idCursos;
  }
  
  
}
