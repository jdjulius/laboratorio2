/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Pelicula;
import excepciones.AccesoDatosEx;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ENA-PC1
 */
public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {

        File archivo = new File(nombreArchivo);

        if (archivo.exists()) {
            return true;
        }

        return false;
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo, String nombre) {
        
        List<Pelicula> peliculas = new ArrayList();

        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
                lectura = entrada.readLine();
            }
            
            String v [] = lectura.split("\n");
            
            for (String n : v) {
                Pelicula p = new Pelicula(n);
                peliculas.add(p);                
            }
            
            
            System.out.println(lectura);
            entrada.close();
            System.out.println("El archivo ha sido leido correctamente");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return peliculas;
        
        
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.getNombre());
            salida.println();
            salida.close();
            System.out.println("El archivo ha sido escrito correctamente");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {

        String pelicula = "";

        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = "";
            while (lectura != null) {
                lectura = entrada.readLine();

                if (lectura.equals(buscar)) {
                    pelicula = lectura;
                    break;
                }

            }
            System.out.println(lectura);
            entrada.close();
            System.out.println("El archivo ha sido leido correctamente");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return pelicula;

    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("El archivo ha sido creado correctamente");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        archivo.delete();
    }

}
