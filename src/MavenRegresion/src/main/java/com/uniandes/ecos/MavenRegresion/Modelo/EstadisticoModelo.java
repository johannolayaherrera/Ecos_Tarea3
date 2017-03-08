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
public class EstadisticoModelo {
    private Nodo numeroHead;
    private double tamanioProxy=0;
    private int cantidadNumeros = 0;
    
    /**
     * Agrega un nodo a la estructura de datos
     * @param linea corresponde a la línea que se lee a partir del archivo de cargue.
     */
    public void agregarNodo(String linea) throws Exception{
        String[] valores;
        valores = linea.split("_");
        if (valores.length==2){
            Nodo nuevoNodo = new Nodo(Double.parseDouble(valores[0]),Double.parseDouble(valores[1]));
            if (numeroHead == null){
            numeroHead = nuevoNodo;  
            }
            else {
                Nodo aux = numeroHead;

                while (aux.obtenerSiguiente()!=null){
                    aux = aux.obtenerSiguiente();
                }  
                aux.agregarSiguiente(nuevoNodo); 
            }
        }
        else {
            throw new Exception("Cada registro debe tener dos valores. Por favor verifique y cargue de nuevo.");
        }    
    }
    
    /**
     * Asigna el valor estimado del proxy 
     * @param valor es el valor estimado del proxy.
     */
    public void ponerValor(double valor){ 
        tamanioProxy = valor;
    }   
    
    /**
     * Retorna el primer elemento de la lista enlazada.
     * @return primer elemento de la lista.
     */
    public Nodo darCabezaLista(){ 
        return numeroHead;
    }   
    
    /**
     * Calcula la suma de los elementos correspondientes a X en la lista enlazada.
     * @return el valor de la sumatoria de X. 
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darSumaX() throws Exception { 
        double cantidadAcumulado = 0;
        if (numeroHead == null){
            throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
        }
        else {
            Nodo aux = numeroHead;
            
            while (aux != null){
                cantidadAcumulado += aux.obtenerNumeroX();
                aux = aux.obtenerSiguiente();
            }
            return cantidadAcumulado;
        }
    }   
    
    /**
     * Calcula la suma de los elementos correspondientes a Y en la lista enlazada.
     * @return el valor de la sumatoria de Y. 
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darSumaY() throws Exception { 
        double cantidadAcumulado = 0;
        if (numeroHead == null){
            throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
        }
        else {
            Nodo aux = numeroHead;
            
            while (aux != null){
                cantidadAcumulado += aux.obtenerNumeroY();
                aux = aux.obtenerSiguiente();
            }
            return cantidadAcumulado;
        }
    } 
    
    /**
     * Calcula la sumatoria de los elementos x elevados al cuadrado.
     * @return el valor de la sumatoria de X^2. 
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darSumaXX() throws Exception { 
        double cantidadAcumulado = 0;
        if (numeroHead == null){
            throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
        }
        else {
            Nodo aux = numeroHead;
            
            while (aux != null){
                cantidadAcumulado += Math.pow(aux.obtenerNumeroX(), 2) ;
                aux = aux.obtenerSiguiente();
            }
            return cantidadAcumulado;
        }
    } 
    
    /**
     * Calcula la sumatoria de los elementos y elevados al cuadrado.
     * @return el valor de la sumatoria de Y^2. 
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darSumaYY() throws Exception { 
        double cantidadAcumulado = 0;
        if (numeroHead == null){
            throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
        }
        else {
            Nodo aux = numeroHead;
            
            while (aux != null){
                cantidadAcumulado += Math.pow(aux.obtenerNumeroY(), 2) ;
                aux = aux.obtenerSiguiente();
            }
            return cantidadAcumulado;
        }
    } 
    
    /**
     * Calcula la sumatoria de los elementos x multiplicados por los elementos y.
     * @return el valor de la sumatoria de X*Y. 
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darSumaXY() throws Exception { 
        double cantidadAcumulado = 0;
        if (numeroHead == null){
            throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
        }
        else {
            Nodo aux = numeroHead;
            
            while (aux != null){
                cantidadAcumulado += aux.obtenerNumeroX() * aux.obtenerNumeroY() ;
                aux = aux.obtenerSiguiente();
            }
            return cantidadAcumulado;
        }
    } 
     /**
     * Calcula la cantidad de registros que se cargaron desde el archivo.
     * @return cantidad de elementos.
     * @throws Exception Se lanza cuando no hay números registrados.
     */
    public double darCantidadElementos()throws Exception{
        double numeradorAcumulado = 0;
        
        Nodo aux = numeroHead;
        while (aux != null){
            numeradorAcumulado ++;
            aux = aux.obtenerSiguiente();
        }
        
        return numeradorAcumulado;            
    }
    /**
     * Calcula el promedio de los valores x 
     * @return el valor del promedio de X. 
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darPromedioX()throws Exception{
        if (darCantidadElementos()>0){
            return (darSumaX()/darCantidadElementos());
        }
        throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
    }
    /**
     * Calcula el promedio de los valores y
     * @return el valor del promedio de Y. 
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darPromedioY()throws Exception{
        if (darCantidadElementos()>0){
            return (darSumaY()/darCantidadElementos());
        }
        throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
    }
    
    /**
     * Calcula la correlación de los datos cargados.
     * @return valor de la correlación.
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darCorrelacion() throws Exception {
        if (darCantidadElementos() > 0) {
            return (Math.pow(((darCantidadElementos() * darSumaXY()) - (darSumaX() * darSumaY()))
                    / (Math.sqrt(((darCantidadElementos() * darSumaXX()) - Math.pow(darSumaX(), 2))
                            * ((darCantidadElementos() * darSumaYY()) - Math.pow(darSumaY(), 2))
                    )), 2));
        }
        throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
    }
    /**
     * Calcula el valor de Beta1 de los datos cargados.
     * @return valor de Beta1
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darBeta1()throws Exception{
        if (darCantidadElementos()>0){
            return (
                    (darSumaXY()-darCantidadElementos()*darPromedioX()*darPromedioY())
                    /
                    (darSumaXX()-darCantidadElementos()*Math.pow(darPromedioX(), 2))
                    );
        }
        throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
    }
    
    /**
     * Calcula el valor de Beta0 de los datos cargados.
     * @return valor de Beta0.
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darBeta0()throws Exception{
        if (darCantidadElementos()>0){
            return (
                    darPromedioY()-darBeta1()*darPromedioX()
                    );
        }
        throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
    }
    
    /**
     * Calcula el valor estimado apartir de los datos cargados y el valor estimado del proxy.
     * @return valor estimado a partir del tamaño del proxy.
     * @throws Exception se lanza cuando no hay registros cargados
     */
    public double darEstimacion()throws Exception{
        if (darCantidadElementos()>0){
            return (
                    darBeta0() + darBeta1()*tamanioProxy
                    );
        }
        throw new Exception("No hay números registrados. Por favor verifique y cargue de nuevo.");
    }
}