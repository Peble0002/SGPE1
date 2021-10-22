/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Abstracción de la clase Curso
 * @author Pablo Chaves, Aaron Soto y Luis Leitón 
 * @version (24/10/2021)
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
   * Constructor de la clase Curso
   * @param pNombre de tipo String
   * @param pIdCursos de tipo String 
   * @param pCreditos de tipo Int
   * @param pHorasLectivas de tipo Int
   */
  public Curso(String pNombre, String pIdCursos, int pCreditos, int pHorasLectivas) {
    this.nombre = pNombre;
    this.idCursos = pIdCursos;
    this.creditos = pCreditos;
    this.horasLectivas = pHorasLectivas;
  }
  
  /**
   * Constructor de la clase Curso
   * @param pIdCursos de tipo String 
   */
  public Curso(String pIdCursos) {
    this.idCursos = pIdCursos;
  }

  
  public String getNombre() {
    return nombre;
  }


  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  
  public String getIdCursos() {
    return idCursos;
  }

  
  public void setIdCursos(String pIdCursos) {
    this.idCursos = pIdCursos;
  }

  
  public int getCreditos() {
    return creditos;
  }

  
  public void setCreditos(int pCreditos) {
    this.creditos = pCreditos;
  }

  
  public int getHorasLectivas() {
    return horasLectivas;
  }

  
  public void setHorasLectivas(int pHorasLectivas) {
    this.horasLectivas = pHorasLectivas;
  }
  
  /**
   * Método para registrar un curso
   * @param pNombre de tipo String
   * @param pIdCursos de tipo String
   * @param pCreditos de tipo int
   * @param pHorasLectivas de tipo int
   */
  public void registrarCurso(String pNombre, String pIdCursos, int pCreditos, int pHorasLectivas) {
    nombre = pNombre;
    idCursos = pIdCursos;
    creditos = creditos;
    horasLectivas = horasLectivas;
    requisitos= new ArrayList<Requisito>();
    correquisitos= new ArrayList<Correquisito>();
  }

  
  public ArrayList<Requisito> getRequisitos() {
    return requisitos;
  }

 
  public void setRequisitos(ArrayList<Requisito> pRequisitos) {
    this.requisitos = pRequisitos;
  }

  
  public ArrayList<Correquisito> getCorrequisitos() {
    return correquisitos;
  }

  
  public void setCorrequisitos(ArrayList<Correquisito> pCorrequisitos) {
    this.correquisitos = pCorrequisitos;
  }


  public Bloque getBloque() {
    return bloque;
  }

  
  public void setBloque(Bloque bloque) {
    this.bloque = bloque;
  }
  
  

  
  
}
