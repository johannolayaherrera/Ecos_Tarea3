/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniandes.ecos.MavenRegresion.Vista;

import java.awt.event.ActionListener;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johann
 */
public class EstadisticoVistaTest {
    
    public EstadisticoVistaTest() {
    }

    /**
     * Test of obtenerExtension method, of class EstadisticoVista.
     */
    @Test
    public void testObtenerExtension() {
        System.out.println("obtenerExtension");
        String nombreArchivo = "prueba.txt";
        EstadisticoVista vista = new EstadisticoVista();
        String esperado = "txt";
        String actual = vista.obtenerExtension(nombreArchivo);
        assertTrue(esperado.equals(actual));
    }
    
}
