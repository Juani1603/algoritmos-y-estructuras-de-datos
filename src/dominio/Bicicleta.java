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
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Bicicleta bicicleta = (Bicicleta) o;
        return this.codigo == bicicleta.codigo && codigo.equals(bicicleta.codigo); 
    }
    
}
