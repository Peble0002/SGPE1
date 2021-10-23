/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

import java.util.ArrayList;

/**
 * Abstracción de la clase EscuelaOAreaAcademica
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
 */
public class EscuelaOAreaAcademica {
  private String nombre;
  private String codigo;
  private ArrayList<PlanDeEstudio> planesEstudio;
  private ArrayList<PlandeEscuela> planes;

  /**
   * Constructor de la clase EscuelaOAreaAcademica
   * @param pNombre de tipo String
   * @param pCodigo de tipo String
   * @param pPlanesEstudio de tipo ArrayList de PlanDeEstudio
   */
  public EscuelaOAreaAcademica(String pNombre, String pCodigo, 
          ArrayList<PlanDeEstudio> pPlanesEstudio) {
    this.nombre = pNombre;
    this.codigo = pCodigo;
    this.planesEstudio = pPlanesEstudio;
    this.planes = new ArrayList<PlandeEscuela>();
    
  }

  /**
   * Constructor de la clase EscuelaOAreaAcademica
   * @param nombre de tipo String
   */
  public EscuelaOAreaAcademica(String nombre) {
    this.nombre = nombre;
    this.planesEstudio = new ArrayList<PlanDeEstudio>();
    this.planes = new ArrayList<PlandeEscuela>();
  }
  
  
  
  /**
   * Constructor de la clase EscuelaOAreaAcademica
   * @param pNombre de tipo String
   * @param pCodigo de tipo String
   */
  public EscuelaOAreaAcademica(String pNombre, String pCodigo) {
    this.nombre = pNombre;
    this.codigo = pCodigo;
    this.planesEstudio = new ArrayList<PlanDeEstudio>();
  }

  /**
   * 
   * @return nombre de la escuela
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * 
   * @param pNombre  nombre de la escuela
   */
  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  /**
   * 
   * @return codigo de la escuela 
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * 
   * @param pCodigo codigo de la escuela
   */
  public void setCodigo(String pCodigo) {
    this.codigo = pCodigo;
  }

  /**
   * 
   * @return  planes de estudios
   */
  public ArrayList<PlanDeEstudio> getPlanesEstudio() {
    return planesEstudio;
  }

  
  /**
   * 
   * @param pPlanEstudio asigna planes de estudios
   */
  public void setPlanesEstudio(ArrayList<PlanDeEstudio> pPlanEstudio) {
    this.planesEstudio = pPlanEstudio;
  }
  
  /**
   * 
   * @param pPlanEstudio asigna plan de estudio
   */
  public void asignarPlanEstudio(PlanDeEstudio pPlanEstudio){
    planesEstudio.add(pPlanEstudio);
  }

  /**
   * 
   * @return Planes de la escuela
   */
  public ArrayList<PlandeEscuela> getPlanes() {
    return planes;
  }

  /**
   * 
   * @param pPlanes asigna Planes de la escuela
   */
  public void setPlanes(ArrayList<PlandeEscuela> pPlanes) {
    this.planes = pPlanes;
  }
    
  
  
  
}
