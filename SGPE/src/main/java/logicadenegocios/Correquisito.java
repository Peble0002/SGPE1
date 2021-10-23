
package logicadenegocios;

/**
  * Abstracción de la clase Correquisito
  * @author Pablo Chaves, Aaron Soto y Luis Leitón 
  * @version (24/10/2021)
 */
public class Correquisito {
  protected String idCursoConsultado;
  protected String idCursoCorrequisito;
  

  /**
   * Constructor de la clase 
   * @param pIdCursoConsultado de tipo String
   * @param pIdCursoCorrequisito de tipo String
  */
  public Correquisito(String pIdCursoConsultado, String pIdCursoCorrequisito) {
    this.idCursoConsultado = pIdCursoConsultado;
    this.idCursoCorrequisito = pIdCursoCorrequisito;
  }

  /**
   * 
   * @return id del curso consultado
   */
  public String getIdCursoConsultado() {
    return idCursoConsultado;
  }

  /**
   * 
   * @param pIdCursoConsultado id del curso consultado
   */
  public void setIdCursoConsultado(String pIdCursoConsultado) {
    this.idCursoConsultado = pIdCursoConsultado;
  }

  /**
   * 
   * @return id del curso correquisito
   */
  public String getIdCursoRequisito() {
    return idCursoCorrequisito;
  }

  /**
   * 
   * @param pIdCursoCorrequisito id del curso correquisito
   */
  public void setIdCursoRequisito(String pIdCursoCorrequisito) {
    this.idCursoCorrequisito = pIdCursoCorrequisito;
  }
  
  
}
