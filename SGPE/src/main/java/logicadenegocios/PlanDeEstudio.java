/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class PlanDeEstudio {
  private EscuelaOAreaAcademica escuela;
  private String numPlan;
  private LocalDate fechaEntradaVigencia;
  private ArrayList<String> cursos;
  private ArrayList<PlandeEscuela> planes;

  /**
   * 
   * @param pEscuela
   * @param pNumPlan
   * @param pFechaEntradaVigencia 
   */
  public PlanDeEstudio(EscuelaOAreaAcademica pEscuela, String pNumPlan, LocalDate pFechaEntradaVigencia) {
    this.escuela = pEscuela;
    this.numPlan = pNumPlan;
    this.fechaEntradaVigencia = pFechaEntradaVigencia;
  }
  
  /**
   * 
   * @param pEscuela
   * @param pNumPlan
   * @param pDia
   * @param pMes
   * @param pAno 
   */
  public PlanDeEstudio(EscuelaOAreaAcademica pEscuela, String pNumPlan, int pDia, int pMes, int pAno) {
    this.escuela = pEscuela;
    this.numPlan = pNumPlan;
    this.fechaEntradaVigencia = LocalDate.of(pAno, pMes, pDia);
  }

  /**
   * 
   * @return 
   */
  public EscuelaOAreaAcademica getEscuela() {
    return escuela;
  }

  /**
   * 
   * @param pEscuela 
   */
  public void setEscuela(EscuelaOAreaAcademica pEscuela) {
    this.escuela = pEscuela;
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

  /**
   * 
   * @return 
   */
  public LocalDate getFechaEntradaVigencia() {
    return fechaEntradaVigencia;
  }

  /**
   * 
   * @param pDia
   * @param pMes
   * @param pAno 
   */
  public void setFechaEntradaVigencia(int pDia, int pMes, int pAno) {
    this.fechaEntradaVigencia = LocalDate.of(pAno, pMes, pDia);
  }

  /**
   * 
   * @param pCurso 
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
   * @return 
   */
  public ArrayList<String> getCursos() {
    return cursos;
  }

  /**
   * 
   * @param pCursos 
   */
  public void setCursos(ArrayList<String> pCursos) {
    this.cursos = pCursos;
  }

  /**
   * 
   * @return 
   */
  public ArrayList<PlandeEscuela> getPlanes() {
    return planes;
  }

  /**
   * 
   * @param pPlanes 
   */
  public void setPlanes(ArrayList<PlandeEscuela> pPlanes) {
    this.planes = pPlanes;
  }
  
  
  
}
