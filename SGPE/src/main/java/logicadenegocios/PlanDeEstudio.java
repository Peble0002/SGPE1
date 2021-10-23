/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Abstracción de la clase PlanDeEstudio
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class PlanDeEstudio {
  private EscuelaOAreaAcademica escuela;
  private String numPlan;
  private LocalDate fechaEntradaVigencia;
  private ArrayList<String> cursos;
  private ArrayList<PlandeEscuela> planes;

  /**
   * Constructor de la clase PlanDeEstudio
   * @param pEscuela de tipo EscuelaOAreaAcademica
   * @param pNumPlan de tipo String
   * @param pFechaEntradaVigencia de tipo LocalDate
   */
  public PlanDeEstudio(EscuelaOAreaAcademica pEscuela, String pNumPlan, 
          LocalDate pFechaEntradaVigencia) {
    this.escuela = pEscuela;
    this.numPlan = pNumPlan;
    this.fechaEntradaVigencia = pFechaEntradaVigencia;
  }
  
  /**
   * Constructor de la clase PlanDeEstudio
   * @param pEscuela de tipo EscuelaOAreaAcademica
   * @param pNumPlan de tipo String
   * @param pDia de tipo int
   * @param pMes de tipo int
   * @param pAno de tipo int
   */
  public PlanDeEstudio(EscuelaOAreaAcademica pEscuela, String pNumPlan, 
          int pDia, int pMes, int pAno) {
    this.escuela = pEscuela;
    this.numPlan = pNumPlan;
    this.fechaEntradaVigencia = LocalDate.of(pAno, pMes, pDia);
  }

  /**
   * 
   * @return escuela del plan de estudio
   */
  public EscuelaOAreaAcademica getEscuela() {
    return escuela;
  }

 
  /**
   * 
   * @param pEscuela escuela del plan de estudio
   */
  public void setEscuela(EscuelaOAreaAcademica pEscuela) {
    this.escuela = pEscuela;
  }

  /**
   * 
   * @return numero de plan de estudio
   */
  public String getNumPlan() {
    return numPlan;
  }

  /**
   * 
   * @param pNumPlan numero de plan de estudio
   */
  public void setNumPlan(String pNumPlan) {
    this.numPlan = pNumPlan;
  }

  /**
   * 
   * @return fecha de vigencia
   */
  public LocalDate getFechaEntradaVigencia() {
    return fechaEntradaVigencia;
  }

  /**
   * 
   * @param pDia día de vigencia
   * @param pMes mees de vigencia
   * @param pAno año de vigencia
   */
  public void setFechaEntradaVigencia(int pDia, int pMes, int pAno) {
    this.fechaEntradaVigencia = LocalDate.of(pAno, pMes, pDia);
  }

  /**
   * Método para agregar cursos
   * @param pIdCurso de tipo String 
   */
  private void agregarCurso(String pIdCurso){
    for (String id: cursos){
      if (id==pIdCurso){
        cursos.add(id);        
      }
      //insertar try exeption
    }
    
  }

  /**
   * 
   * @return cursos
   */
  public ArrayList<String> getCursos() {
    return cursos;
  }

 /**
  * 
  * @param pCursos asigna cursos
  */
  public void setCursos(ArrayList<String> pCursos) {
    this.cursos = pCursos;
  }

  /**
   * 
   * @return plan de estudio
   */
  public ArrayList<PlandeEscuela> getPlanes() {
    return planes;
  }

 /**
  * 
  * @param pPlanes asigna plan de estudio
  */
  public void setPlanes(ArrayList<PlandeEscuela> pPlanes) {
    this.planes = pPlanes;
  }
  
  
  
}
