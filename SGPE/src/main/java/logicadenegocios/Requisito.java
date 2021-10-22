/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

/**
 * Abstracción de la clase Requisito
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class Requisito {
  protected String idCursoConsultado;
  protected String idCursoRequisito;
  

  /**
   * Constructor de la clase Requisito
   * @param pIdCursoConsultado de tipo String
   * @param pIdCursoRequisito de tipo String
   */
  public Requisito(String pIdCursoConsultado, String pIdCursoRequisito) {
    this.idCursoConsultado = pIdCursoConsultado;
    this.idCursoRequisito = pIdCursoRequisito;
  }

  
  public String getIdCursoConsultado() {
    return idCursoConsultado;
  }

 
  public void setIdCursoConsultado(String pIdCursoConsultado) {
    this.idCursoConsultado = pIdCursoConsultado;
  }

  
  public String getIdCursoRequisito() {
    return idCursoRequisito;
  }

  
  public void setIdCursoRequisito(String pIdCursoRequisito) {
    this.idCursoRequisito = pIdCursoRequisito;
  }
  
  
}
