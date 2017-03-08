/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Conceptos Avanzados de Ingeniería de Software
 *
 * Proyecto Regresión
 * Tarea 3
 * Autor: Johann Olaya
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.uniandes.ecos.MavenRegresion.Modelo;

/**
 *
 * @author Johann
 */
public class Nodo {
    private double numerox;
    private double numeroy;  
    private Nodo siguiente;
    
    /**
     * Construye un objeto Nodo
     * @param nuevoX es el número asignado a x
     * * @param nuevoY es el número asignado a y
     */
    public Nodo(double nuevoX,double nuevaY){
        numerox = nuevoX;
        numeroy = nuevaY;
    }
    
    /**
     * Asigna la referencia del nodo siguiente 
     * @param siguienteAsignado objeto asignado como siguiente en la lista enlazada
     */
    public void agregarSiguiente(Nodo siguienteAsignado){
        siguiente = siguienteAsignado;
    }
    
    /**
     * @return retorna la referencia del nodo siguiente
     */
    public Nodo obtenerSiguiente(){
        return siguiente;
    }
    
    /**
     * @return retorna el valor de x.
     */
    public double obtenerNumeroX(){
        return numerox;
    }
    /**
     * @param nuevoNumero valor asignado a x.
     */
    public void asignarNumeroX(double nuevoNumero){
        numerox = nuevoNumero;
    }
    
     /**
     * @return retorna el valor asignado a y.
     */
    public double obtenerNumeroY(){
        return numeroy;
    }
    /**
     * @param nuevoNumero valor asignado a y.
     */
    public void asignarNumeroY(double nuevoNumero){
        numeroy = nuevoNumero;
    }
    
}