package dominio;

public class Bicicleta {
    public enum Estado{
      DISPONIBLE, MANTENIMIENTO, ALQUILADA  
    };
    private String codigo;
    private String tipo;
    private Estado estado;
    

    public Bicicleta(String codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.estado = Estado.DISPONIBLE;
    }

    public Bicicleta(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Estado getEstado(){
        return estado;
    }
    
    public void SetEstado(Estado estado){
        this.estado = estado;
    }
    
     @Override
    public boolean equals(Object o) {
        return this.getCodigo().equalsIgnoreCase(((Bicicleta)o).getCodigo());
    }
    
}
