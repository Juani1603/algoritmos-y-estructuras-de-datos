package dominio;

public class Usuario {

    private String cedula;
    private String nombre;

    public Usuario(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
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
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Usuario usuario = (Usuario) o;
        return this.cedula == usuario.cedula && cedula.equals(usuario.cedula); 
    }

}
