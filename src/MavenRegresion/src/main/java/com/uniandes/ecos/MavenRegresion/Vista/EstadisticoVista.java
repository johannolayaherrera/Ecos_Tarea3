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
package com.uniandes.ecos.MavenRegresion.Vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;



/**
 * Esta clase representa la interfaz de usuario
 * @author Johann
 */
public class EstadisticoVista extends JFrame{
    private JLabel lblRuta ;
    private JTextField tbfRuta;
    private JLabel lblValor ;
    private JTextField tbfValor;
    private JButton btnCalcular;

    
    /**
     * Construye la interfaz de usuario
     */
    public EstadisticoVista(){
        setTitle("PSP2 - Universidad de los Andes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,1));
        setSize(600,200);
        lblRuta = new JLabel("Por favor ingrese la ruta del archivo que desea cargar.");
        tbfRuta = new JTextField();
        lblValor = new JLabel("Ingrese el tamaño estimado del proxy.");
        tbfValor = new JTextField();
        btnCalcular = new JButton("Calcular");
        add(lblRuta);
        add(tbfRuta);
        add(lblValor);
        add(tbfValor);
        add(btnCalcular);     
        setVisible(true);
    }

    /**
     * Obtiene la ruta del archivo de texto plano.
     * @return ruta del archivo de texto plano.
     */
    public String obtenerRuta()throws Exception {
        if (obtenerExtension(tbfRuta.getText()).equals("txt")){
            return tbfRuta.getText();
        }
        else {
            throw new Exception("Debe cargar un archivo .txt");
        }
    }
    
     /**
     * Obtiene el valor estimado del proxy.
     * @return valor estimado del proxy.
     */
    public Double obtenerValor()throws Exception {
        try {
            Double valor = Double.parseDouble(tbfValor.getText().trim());
            return valor;
        }
        catch(Exception ex){
            throw new Exception("Hubo un error al ingresar el valor estimado del proxy,"
                    + " por favor revisar y cargar de nuevo");
        }
    }

    /**
     * Envento del botón calcular que será manejado en el controlador
     * @param calcular 
     */
    public void addCalcular(ActionListener calcular){
        btnCalcular.addActionListener(calcular);
    }

    /**
     * Muestra mensaje
     * @param mensaje es el mensaje que va a mostrarse
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        System.exit(HIDE_ON_CLOSE);
    }
     /**
     * Retorna la extensión del archivo ingresado.
     * @param extensión del archivo ingresado.
     */
    public String obtenerExtension(String nombreArchivo) {
        int index = nombreArchivo.lastIndexOf('.');
        if (index == -1) {
            return "";
        } 
        else {
            return nombreArchivo.substring(index + 1);
        }
    }
}