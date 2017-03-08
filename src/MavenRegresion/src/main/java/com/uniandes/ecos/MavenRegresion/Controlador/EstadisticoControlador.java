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
package com.uniandes.ecos.MavenRegresion.Controlador;
import com.uniandes.ecos.MavenRegresion.Modelo.*;
import com.uniandes.ecos.MavenRegresion.Vista.EstadisticoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta clase representa el controlador el cual interactua con la vista y el
 * modelo
 *
 * @author Johann
 */
public class EstadisticoControlador {

    private EstadisticoVista vista;
    private EstadisticoModelo modelo;

    /**
     * Constructor del controlador
     *
     */
    public EstadisticoControlador (EstadisticoVista vista, EstadisticoModelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addCalcular(new calcular());
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        EstadisticoVista vista  = new EstadisticoVista();
        EstadisticoModelo modelo = new EstadisticoModelo();
        EstadisticoControlador controlador = new EstadisticoControlador(vista,modelo);
    }


    /**
     * Clase para manejar el evento de la vista desde el controlador carga el
     * modelo y la vista
     */
    class calcular implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                cargarModelo(vista.obtenerRuta());
                String resultado = "El parámetro Bo : ";
                resultado += String.format("%.8g%n", modelo.darBeta0());
                resultado += "\nEl parámetro B1 : ";
                resultado += String.format("%.8g%n", modelo.darBeta1());
                resultado += "\nLa correlación : ";
                resultado += String.format("%.8g%n", modelo.darCorrelacion());
                resultado += "\nEstimación : ";
                resultado += String.format("%.8g%n", modelo.darEstimacion());
                
                vista.mostrarMensaje(resultado);
            } 
            catch (Exception ex) {
                vista.mostrarMensaje("Ha ocurrido un error al cargar el archivo : " + ex.getMessage());
            }

        }
    }

    /**
     * Carga el modelo a partir de un archivo de texto (.txt)
     * @param ruta ubicación del archivo de texto (.txt)
     */
    private void cargarModelo(String ruta) throws Exception {
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            String sCurrentLine;
            modelo.ponerValor(vista.obtenerValor());
            br = new BufferedReader(new FileReader(ruta));

            while ((sCurrentLine = br.readLine()) != null) {
                sCurrentLine = sCurrentLine.trim();
                modelo.agregarNodo(sCurrentLine);
            }

        } 
        catch (IOException e) {
            vista.mostrarMensaje("Ha ocurrido un error al cargar el archivo : " + e.getMessage());
        }
    }

}
