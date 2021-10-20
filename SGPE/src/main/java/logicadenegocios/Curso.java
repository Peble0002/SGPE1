/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author pablo aaron luis
 */
public class Curso {
  private String nombre;
  private String idCursos;
  private int creditos;
  private int horasLectivas;
  private ArrayList<Requisito> requisitos;
  private ArrayList<Correquisito> correquisitos;
  private Bloque bloque;

  /**
   * @param pNombre
   * @param pIdCursos
   * @param pCreditos
   * @param pHorasLectivas 
   */
  public Curso(String pNombre, String pIdCursos, int pCreditos, int pHorasLectivas) {
    this.nombre = pNombre;
    this.idCursos = pIdCursos;
    this.creditos = pCreditos;
    this.horasLectivas = pHorasLectivas;
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
  public String getIdCursos() {
    return idCursos;
  }

  /**
   * 
   * @param pIdCursos 
   */
  public void setIdCursos(String pIdCursos) {
    this.idCursos = pIdCursos;
  }

  /**
   * 
   * @return 
   */
  public int getCreditos() {
    return creditos;
  }

  /**
   * 
   * @param pCreditos 
   */
  public void setCreditos(int pCreditos) {
    this.creditos = pCreditos;
  }

  /**
   * 
   * @return 
   */
  public int getHorasLectivas() {
    return horasLectivas;
  }

  /**
   * 
   * @param pHorasLectivas 
   */
  public void setHorasLectivas(int pHorasLectivas) {
    this.horasLectivas = pHorasLectivas;
  }
  
  /**
   * 
   * @param pNombre
   * @param pIdCursos
   * @param pCreditos
   * @param pHorasLectivas 
   */
  public void registrarCurso(String pNombre, String pIdCursos, int pCreditos, int pHorasLectivas) {
    nombre = pNombre;
    idCursos = pIdCursos;
    creditos = creditos;
    horasLectivas = horasLectivas;
    requisitos= new ArrayList<Requisito>();
    correquisitos= new ArrayList<Correquisito>();
  }

  /**
   * 
   * @return 
   */
  public ArrayList<Requisito> getRequisitos() {
    return requisitos;
  }

  /**
   * 
   * @param pRequisitos 
   */
  public void setRequisitos(ArrayList<Requisito> pRequisitos) {
    this.requisitos = pRequisitos;
  }

  /**
   * 
   * @return 
   */
  public ArrayList<Correquisito> getCorrequisitos() {
    return correquisitos;
  }

  /**
   * 
   * @param pCorrequisitos 
   */
  public void setCorrequisitos(ArrayList<Correquisito> pCorrequisitos) {
    this.correquisitos = pCorrequisitos;
  }

  /**
   * 
   * @return 
   */
  public Bloque getBloque() {
    return bloque;
  }

  /**
   * 
   * @param bloque 
   */
  public void setBloque(Bloque bloque) {
    this.bloque = bloque;
  }
  
  

  
  
}
