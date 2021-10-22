
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

  
  public String getIdCursoConsultado() {
    return idCursoConsultado;
  }

  
  public void setIdCursoConsultado(String pIdCursoConsultado) {
    this.idCursoConsultado = pIdCursoConsultado;
  }

  
  public String getIdCursoRequisito() {
    return idCursoCorrequisito;
  }

  
  public void setIdCursoRequisito(String pIdCursoCorrequisito) {
    this.idCursoCorrequisito = pIdCursoCorrequisito;
  }
  
  
}
