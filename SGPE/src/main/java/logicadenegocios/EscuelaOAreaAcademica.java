/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

import java.util.ArrayList;

/**
 *
 * @author pablo luis aaron
 */
public class EscuelaOAreaAcademica {
  private String nombre;
  private String codigo;
  private ArrayList<PlanDeEstudio> planesEstudio;
  private ArrayList<PlandeEscuela> planes;

  /**
   * 
   * @param pNombre
   * @param pCodigo
   * @param pPlanesEstudio 
   */
  public EscuelaOAreaAcademica(String pNombre, String pCodigo, 
          ArrayList<PlanDeEstudio> pPlanesEstudio) {
    this.nombre = pNombre;
    this.codigo = pCodigo;
    this.planesEstudio = pPlanesEstudio;
    this.planes = new ArrayList<PlandeEscuela>();
    
  }

  public EscuelaOAreaAcademica(String nombre) {
    this.nombre = nombre;
    this.planesEstudio = new ArrayList<PlanDeEstudio>();
    this.planes = new ArrayList<PlandeEscuela>();
  }
  
  
  
  /**
   * 
   * @param pNombre
   * @param pCodigo 
   */
  public EscuelaOAreaAcademica(String pNombre, String pCodigo) {
    this.nombre = pNombre;
    this.codigo = pCodigo;
    this.planesEstudio = new ArrayList<PlanDeEstudio>();
  }

  /**
   * 
   * @return 
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * 
   * @param pNombre 
   */
  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  /**
   * 
   * @return 
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * 
   * @param pCodigo 
   */
  public void setCodigo(String pCodigo) {
    this.codigo = pCodigo;
  }

  /**
   * 
   * @return 
   */
  public ArrayList<PlanDeEstudio> getPlanesEstudio() {
    return planesEstudio;
  }

  /**
   * 
   * @param pPlanEstudio 
   */
  public void setPlanesEstudio(ArrayList<PlanDeEstudio> pPlanEstudio) {
    this.planesEstudio = pPlanEstudio;
  }
  
  /**
   * 
   * @param pPlanEstudio 
   */
  public void asignarPlanEstudio(PlanDeEstudio pPlanEstudio){
    planesEstudio.add(pPlanEstudio);
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
