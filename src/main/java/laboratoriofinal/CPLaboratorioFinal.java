/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriofinal;

import java.util.Scanner;
import negocio.CatalogoPeliculas;
import negocio.CatalogoPeliculasImpl;

/**
 *
 * @author ENA-PC1
 */
public class CPLaboratorioFinal {

    static Scanner scanner;
    static int opcion;
    static String nombre = "C:\\Archivo_laboratorio2\\";
    static CatalogoPeliculas catalogoPeliculas;

    public static void main(String[] args) {

        catalogoPeliculas = new CatalogoPeliculasImpl();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Elije opcion:");
            System.out.println("1.- Iniciar catalogo peliculas");
            System.out.println("2.- Agregar peliculas");
            System.out.println("3.- Listar pelicula");
            System.out.println("4.- Buscar pelicula");
            System.out.println("0.- Salir");

            opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {
                System.out.println("Elije opcion:");
                System.out.println("1.- Crear");
                System.out.println("2.- Borrar");
                System.out.println("3.- Existe");
                opcion = Integer.parseInt(scanner.nextLine());

                if (opcion == 1) {
                    String n = scanner.nextLine();
                    catalogoPeliculas.iniciarArchivo(nombre + n);
                    //catalogoPeliculas.DATOS.crear(nombre + n);
                    System.out.println("CREADO CON EXITO");

                } else if (opcion == 2) {
                    String n = scanner.nextLine();
                    catalogoPeliculas.DATOS.borrar(nombre + n);
                    System.out.println("BORRADO CON EXITO");

                } else if (opcion == 3) {
                    String n = scanner.nextLine();
                    boolean e = catalogoPeliculas.DATOS.existe(nombre + n);
                    if (e) {
                        System.out.println("EXISTE");

                    } else {
                        System.out.println("NO EXISTE");

                    }

                }

            } else if (opcion == 2) {
                System.out.println("INGRESE EL NOMBRE DE LA PELICULA:");
                String nombrePelicula = scanner.nextLine();
                System.out.println("INGRESE EL NOMBRE DE ARCHIVO DONDE GUARDARA:");
                String nombreArchivo = scanner.nextLine();
                catalogoPeliculas.agregarPelicula(nombrePelicula,nombre +  nombreArchivo);

                System.out.println("SE AGREGO LA PELICULA CORRECTAMENTE");

            } else if (opcion == 3) {
                System.out.println("INGRESE EL NOMBRE DE ARCHIVO A LISTAR:");
                String nombreArchivo = scanner.nextLine();
                catalogoPeliculas.listarPeliculas(nombre + nombreArchivo);

                System.out.println("SE LISTO LAS PELICULAS CORRECTAMENTE");

            } else if (opcion == 4) {
                System.out.println("INGRESE EL NOMBRE DE ARCHIVO A LISTAR:");
                String nombreArchivo = scanner.nextLine();
                System.out.println("QUE QUIERE BUSCAR?");
                String datoBuscar = scanner.nextLine();
                catalogoPeliculas.buscarPelicula(nombre + nombreArchivo, datoBuscar);

                System.out.println("SE BUSCO LAS PELICULAS CORRECTAMENTE");

            } else if (opcion == 0) {
                System.out.println("opcion0");

                break;
            }
        }

        System.out.println("TERMINADO");
    }
}
