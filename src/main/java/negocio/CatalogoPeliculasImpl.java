/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.AccesoDatos;
import datos.AccesoDatosImpl;
import domain.Pelicula;
import java.util.List;

/**
 *
 * @author ENA-PC1
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    public CatalogoPeliculasImpl() {
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {

        Pelicula p = new Pelicula(nombrePelicula);

        DATOS.escribir(p, nombreArchivo, true);

    }

    @Override
    public void listarPeliculas(String nombreArchivo) {

        List<Pelicula> lista = DATOS.listar(nombreArchivo);

        for (Pelicula pelicula : lista) {

            System.out.println(pelicula);

        }

    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {

        String dato = DATOS.buscar(nombreArchivo, buscar);
        System.out.println("Se econtro: " + dato);

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {

        DATOS.crear(nombreArchivo);

    }

}
