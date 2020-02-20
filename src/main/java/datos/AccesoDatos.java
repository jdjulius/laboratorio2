/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Pelicula;
import excepciones.AccesoDatosEx;
import java.util.List;

/**
 * 
 * @author Julio
 * 
 */
public interface AccesoDatos {

    public boolean existe(String nombreArchivo);

    public List<Pelicula> listar(String nombreArchivo);

    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);

    public String buscar(String nombreArchivo, String buscar);

    public void crear(String nombreArchivo);

    public void borrar(String nombreArchivo);

}
