public class Pelicula  {
    private int clave;
    private int ranking;
    private String nombrePelicula;
    private String nombreDirector;
    private String genero;
    private String anio;
    private String duracion;
    private String sinopsis;
    private String clasificacion;
    public String nombre;
     
     public Pelicula(int clave, String nombrePelicula, String nombreDirector, String genero, String anio, String duracion, String sinopsis, String clasificacion) {
      this.clave = clave;
      this.nombrePelicula= nombrePelicula;
      this.nombreDirector= nombreDirector;
      this.genero = genero;
      this.anio = anio;
      this.duracion = duracion;
      this.sinopsis = sinopsis;
      this.clasificacion = clasificacion;
    
    }
    public int getClave() {
        return clave;
    }
    
    public void setClave(int clave) {
      this.clave = clave;
    }
    
    public String getNombrePelicula() {
        return nombrePelicula;
    }
    
    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }
    
    public String getNombreDirector() {
      return nombreDirector;
    }
    
    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
      this.genero = genero;
    }
    
    public String getAnio() {
        return anio;
    }
    
    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    public String getDuracion() {
        return duracion;
    }
    
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
    public String getSinopsis() {
        return sinopsis;
    }
    
    public void setSinopsis(String sinopsis) {
       this.sinopsis = sinopsis;
    }
    
    public String getClasificacion() {
       return clasificacion;
    }
     
    public void setClasificacion(String clasicacion) {
       this.clasificacion = clasicacion;
    }

    public int getRanking(){
        return ranking;
    }

    public void setRanking(int ranking){
        this.ranking = ranking;
    }
    
    public String formatoArchivo(){
        return clave + "|" + nombrePelicula + "|" + nombreDirector + "|" + genero + "|" + duracion + "|" + anio + "|" + sinopsis + "|" + clasificacion;
    }
    
    public String toString() {
        return "Peliculas{" +
        "clave" + clave +
        ", nombrePelicula='" + nombrePelicula + '\'' +
        ", nombreDirector='" + nombreDirector+ '\'' +
        ", genero='" + genero + '\'' +
        ", anio='" + anio + '\''  +
        ", duracion=" + duracion + '\'' +
        ", sinopsis=" + sinopsis + '\'' +
        ", clasicacion=" + clasificacion + '\'' + '}';
    }
}