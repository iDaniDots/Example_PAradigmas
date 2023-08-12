/**
 * Catalogo
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.*;

public class Catalogo {
    private ArrayList<Pelicula> listaPeliculas;

    public Catalogo(){
        listaPeliculas = new ArrayList<>();
    }

    public void setListaPeliculas(ArrayList<Pelicula> lista) {
        this.listaPeliculas = lista;
    }

    public ArrayList<Pelicula> getListaPeliculas(){
        return listaPeliculas;
    }

    public void insertarPelicula(Pelicula peliculax){
        listaPeliculas.add(peliculax);
    }

    public void mostrarPelicula(int indice){
        Pelicula aux = listaPeliculas.get(indice);
        System.out.printf("%-8s|%-70s|%-30s|%-15s|%-7s|%-3s|%-150s\n", "Clave", "Nombre Pelicula", "Director","Genero", "Año", "Duración", "Clasificación", "Sinopsis");
        System.out.println("--------|--------------------------------------------------------------------------|" + "------------------------------|---------------|-------|"+"---|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-8d|%-70s|%-30s|%-15s|%-7s|%-150s\n", aux.getClave(), aux.getNombrePelicula(), aux.getNombreDirector(), aux.getAnio());
    }

    public int buscarPeliculaPorClaveSecuencial (int claveABuscar){  //Búsqueda secuencial
        for (int i = 0; i < listaPeliculas.size(); i++) {
            if(listaPeliculas.get(i).getClave() == claveABuscar){
                return i;
            }
        }
        return -1;
    }

    public void borrarPelicula(int clave){
        Iterator<Pelicula> peliculaIterator = listaPeliculas.iterator();
        while (peliculaIterator.hasNext()) {
            Pelicula peliculax = peliculaIterator.next();
            if(clave == peliculax.getClave()){
                peliculaIterator.remove();
            }
        }
    }//Fin de borrar pelicula

    public void cambiarNombrePelicula(int indice, String nuevoNombre) {
        Pelicula peliAux = listaPeliculas.get(indice);
        peliAux.setNombrePelicula(nuevoNombre);
    } //Fin de cambiar nombre

    public int buscarPeliculaPorNombre(String nombreABuscar) {  //Busqueda Secuencial
        for (int i = 0; i < listaPeliculas.size(); i++) {
            if (listaPeliculas.get(i).getNombrePelicula().equals(nombreABuscar)) {
                return i;                
            }
        }
        return -1;
    }

    public int buscarPeliculaPorClaveBinaria (int claveABuscar){
        int bajo = 0;
        int alto = listaPeliculas.size() - 1;
        int buscando;
        while (bajo <= alto) {
            int mitad = (bajo + alto) / 2;
            buscando = listaPeliculas.get(mitad).getClave();
            if (buscando == claveABuscar) {
                return mitad;
            } else if (buscando > claveABuscar){
                alto = mitad - 1;
            } else if (buscando < claveABuscar){
                bajo = mitad + 1;
            }
        }
        return -1;
    }

    public void ordenarClaves() { //Ordena por método burburja
        Pelicula aux;
        int N = listaPeliculas.size();
        for (int i = 0; i <= N - 2; i++) {
            for (int j = 0; j <= N - 2; j++) {
                if (listaPeliculas.get(j).getClave() > listaPeliculas.get(j + 1).getClave()){
                    aux = listaPeliculas.get(j);
                    listaPeliculas.set(j, listaPeliculas.get(j + 1));
                    listaPeliculas.set(j + 1, aux);
                }
            }
        }
    }

    public void verCatalogo(){
        System.out.printf("%-8s|%-70s|%-30s|%-15s|%-7s|%-3s|%-150s\n", "Clave", "Nombre Pelicula", "Director","Genero", "Año", "Duracio", "Clasificación", "Sinopsis");
        System.out.println("--------|--------------------------------------------------------------------------|" + "------------------------------|---------------|-------|"+"---|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Pelicula aux : listaPeliculas){
            //Aquí si lleva el % según el tipo
            System.out.printf("%-8d|%-70s|%-30s|%-15s|%-7s|%-7s|%-3s|%-150s\n" + aux.getClave(), aux.getNombrePelicula(), aux.getNombreDirector(),aux.getGenero(), aux.getAnio(), aux.getDuracion(), aux.getClasificacion(), aux.getSinopsis());
        }
    }

    public static void guardarPelicula() throws IOException{
        File archivo = new File ("listaPeliculas");
        
    }
}