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
public class Requisito {
  protected String idCursoConsultado;
  protected String idCursoRequisito;
  

  /**
   * 
   * @param pIdCursoConsultado
   * @param pIdCursoRequisito 
   */
  public Requisito(String pIdCursoConsultado, String pIdCursoRequisito) {
    this.idCursoConsultado = pIdCursoConsultado;
    this.idCursoRequisito = pIdCursoRequisito;
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
    return idCursoRequisito;
  }

  /**
   * 
   * @param pIdCursoRequisito 
   */
  public void setIdCursoRequisito(String pIdCursoRequisito) {
    this.idCursoRequisito = pIdCursoRequisito;
  }
  
  
}
