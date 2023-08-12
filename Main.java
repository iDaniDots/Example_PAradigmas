/**
 * Main
 */
import java.util.Scanner;

public class Main {
    static Catalogo catalogoTienda = new Catalogo();
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args){
        catalogoTienda.verCatalogo();  // Para ver las peliculas del catalogo
        int opcion, indice;
        int clave;
        String nombrePelicula;
        do {
            menu();
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    pedirDatosPelicula();
                    break;

                case 2:
                    catalogoTienda.ordenarClaves();
                    catalogoTienda.verCatalogo();
                    break;

                case 3:
                    System.out.println("Dame la clave de la pelicula a buscar: ");
                    clave = entrada.nextInt();
                    indice = catalogoTienda.buscarPeliculaPorClaveSecuencial(clave);
                    if (indice != -1) {
                        catalogoTienda.mostrarPelicula(indice);
                    } else {
                        System.out.println("No se encontró");
                    }
                    break;

                case 4:
                    System.out.println("Buscar una Pelicula por clave (B. Binaria)");
                    //Primero se ordenan los elementos y luego se hace la búsqueda
                    catalogoTienda.ordenarClaves();
                    System.out.println("Dame la clave de la pelicula a buscar: ");
                    clave = entrada.nextInt();
                    indice = catalogoTienda.buscarPeliculaPorClaveBinaria(clave);
                    if (indice != 1) {
                        catalogoTienda.mostrarPelicula(indice);
                    } else {
                        System.out.println("No se encontró");
                    }
                    break;

                case 5:
                    System.out.println("Buscar una pelicula por nombre (B.Secuencial)");
                    System.out.println("Dame el nombre de la pelicula a buscar: ");
                    //Deben de coincidir losnombres en mayúsculas y minúsculas
                    nombrePelicula = entrada.nextLine();
                    indice = catalogoTienda.buscarPeliculaPorNombre(nombrePelicula);
                    if (indice != 1) {
                        catalogoTienda.mostrarPelicula(indice);
                    } else {
                        System.out.println("No se encontró la pelicula");
                    }
                    break;

                case 6:
                    System.out.println("Dame la clave de la pelicula a borrar:");
                    clave = entrada.nextInt();
                    indice = catalogoTienda.buscarPeliculaPorClaveSecuencial(clave);
                    if(indice == -1){
                        System.out.println("La clave no existe. Repite la operación");
                    } else {
                        catalogoTienda.borrarPelicula(clave);
                        System.out.println("La Pelicula se ha eliminado");
                        catalogoTienda.verCatalogo();
                    }
                    break;

                case 7:
                    cambiarNombrePelicula();
                    break;

                case 8:
                    System.out.println("Mostrar el total");
                    break;

                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No valido");
                    break;
            } //Fin de switch
        } while (opcion != 9);
    }

    private static void menu(){
        imprimirLinea();
        System.out.println("Operaciones sobre peliculas");
        System.out.println("1.- Añadir una pelicula a la lista");
        System.out.println("2.- Mostrar lista de peliculas");
        System.out.println("3.- Buscar una Pelicula por clave (B. Secuencial)");
        System.out.println("4.- Buscar una Pelicula por clave (B. Binaria)");
        System.out.println("5.- Buscar una Pelicula por nombre (B. Secuencial)");
        System.out.println("6.- Borrar una Pelicula");
        System.out.println("7.- Cambiar el nombre de una Pelicula");
        System.out.println("8.- Mostrar el total de peliculas");
        System.out.println("9.- Salir");
        System.out.println("Elige tu opción: ");
    }  //Fin de menú

    public static void pedirDatosPelicula() {
        int clavex;
        String aniox, nombrePeliculax, nombreDirectorx, generox, duracionx, clasificacionx, sinopsisx;
        System.out.println("Dame la clave de la Pelicula: ");
        clavex = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Dame el nombre de la Pelicula: ");
        nombrePeliculax = entrada.nextLine();
        System.out.println("Dame el nombre del Director: ");
        nombreDirectorx = entrada.nextLine();
        System.out.println("Dame el nombre del género: ");
        generox = entrada.nextLine();
        System.out.println("Dame el año de estreno: ");
        aniox = entrada.nextLine();
        System.out.println("Dame la duración de la pelicula: ");
        duracionx = entrada.nextLine();
        System.out.println("Dame la clasificación que tiene la pelicula: ");
        clasificacionx = entrada.nextLine();
        System.out.println("EScriba la sinopsis de la pelicula: ");
        sinopsisx = entrada.nextLine();

        Pelicula peliculax = new Pelicula(clavex, nombrePeliculax, nombreDirectorx, generox, aniox, duracionx, sinopsisx, clasificacionx);
        catalogoTienda.insertarPelicula(peliculax);
    }

    public static void imprimirLinea() {
        System.out.println("----------------------------------------------------" + "------------------------");        
    }

    private static void cambiarNombrePelicula() {
        int clave, indice;
        System.out.println("Cambiar nombre");
        System.out.println("Dame la clave de la pelicula: ");
        clave = entrada.nextInt();
        indice = catalogoTienda.buscarPeliculaPorClaveSecuencial(clave);
        if (indice == -1) {
            System.out.println("La clave no existe. Repite la operación");
            System.out.println();

        } else {
            entrada.nextLine();
            System.out.println("Datos de la Pelicula");
            catalogoTienda.mostrarPelicula(indice);
            System.out.println();
            System.out.println("Dame el nuevo nombre de la Pelicula: ");
            String nombrePelicula = entrada.nextLine();
            catalogoTienda.cambiarNombrePelicula(indice, nombrePelicula);
            System.out.println("Cambios guardados");
            System.out.println();
        }
    }
}