import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo2 {
  private String nombreArchivo;

  public Archivo2(String nombreA2) {
    this.nombreArchivo = nombreA2;
  }

  public void crearArchivo() {
    File archivo = new File(nombreArchivo);
    if (!archivo.exists()) {
      try {
        PrintWriter salidaArchivo = new PrintWriter(nombreArchivo);
        System.out.println("El archivo" + nombreArchivo + "se ha creado.");
        salidaArchivo.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void escribirEnArchivo(ArrayList<Favoritos> listaFavoritos) {

    try {
      PrintWriter salidaArchivo = new PrintWriter(nombreArchivo);
      for (Favoritos favoritox : listaFavoritos) {
        salidaArchivo.println(favoritox.formatoArchivo());
      }
      salidaArchivo.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Favoritos> leerDeArchivo() {
    ArrayList<Favoritos> listaFavoritos = new ArrayList<>();
    try {
      File archivoLectura = new File(nombreArchivo);
      Scanner leerArchivo = new Scanner(archivoLectura);
      while (leerArchivo.hasNext()) {
        String linea = leerArchivo.nextLine();
        String[] valores = linea.split("\\|");
        int clave = Integer.parseInt(valores[0]);
        String nombrePelicula = valores[1];
        int nombreRanking = Integer.parseInt(valores[2]);

        Favoritos favoritox = new Favoritos(clave, nombrePelicula, nombreRanking);
        listaFavoritos.add(favoritox);
      }
      leerArchivo.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
    return listaFavoritos;
  }
}