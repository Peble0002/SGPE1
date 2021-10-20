
package logicadenegocios;

/**
 *
 * @author pablo Luis Aaron
 */
public class Correquisito {
  protected String idCursoConsultado;
  protected String idCursoCorrequisito;
  

  /**
   * 
   * @param pIdCursoConsultado
   * @param pIdCursoRequisito 
   */
  public Correquisito(String pIdCursoConsultado, String pIdCursoCorrequisito) {
    this.idCursoConsultado = pIdCursoConsultado;
    this.idCursoCorrequisito = pIdCursoCorrequisito;
  }

  /**
   * 
   * @return 
   */
  public String getIdCursoConsultado() {
    return idCursoConsultado;
  }

  /**
   * 
   * @param pIdCursoConsultado 
   */
  public void setIdCursoConsultado(String pIdCursoConsultado) {
    this.idCursoConsultado = pIdCursoConsultado;
  }

  /**
   * 
   * @return 
   */
  public String getIdCursoRequisito() {
    return idCursoCorrequisito;
  }

  /**
   * 
   * @param pIdCursoRequisito 
   */
  public void setIdCursoRequisito(String pIdCursoCorrequisito) {
    this.idCursoCorrequisito = pIdCursoCorrequisito;
  }
  
  
}
