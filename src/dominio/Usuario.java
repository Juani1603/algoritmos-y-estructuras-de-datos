package dominio;

public class Usuario implements Comparable<Usuario>{

    private String cedula;
    private String nombre;

    public Usuario(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
    public Usuario(String cedula){
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        return this.getCedula().equalsIgnoreCase(((Usuario)o).getCedula());
    }

    @Override
    public String toString() {
        return this.getNombre() + "#" + this.getCedula();
    }

    @Override
    public int compareTo(Usuario o) {
         return this.getNombre().compareToIgnoreCase(o.getNombre());
    }

}
