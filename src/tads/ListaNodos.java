package tads;

public class ListaNodos<T> implements ILista<T> {

    private Nodo inicio;
    private Nodo fin;
    private int cantElementos;

    public ListaNodos() {
        inicio = null;
        cantElementos = 0;
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public void agregarInicio(T n) {

        Nodo nuevo = new Nodo(n);

        nuevo.setSiguiente(inicio);
        inicio = nuevo;
        cantElementos++;

    }

    @Override
    public void agregarFinal(T n) {

        if (esVacia()) {
            agregarInicio(n);
        } else {
            Nodo nuevo = new Nodo(n);
            Nodo aux = inicio;

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);
            cantElementos++;

        }
    }

    @Override
    public void borrarInicio() {
        if (!esVacia()) {

            Nodo aBorrar = inicio;
            inicio = inicio.getSiguiente();
            aBorrar.setSiguiente(null);
            cantElementos--;
        }
    }

    @Override
    public void borrarFin() {

        if (!esVacia()) {

            if (inicio.getSiguiente() == null) { //solo tengo 1
                vaciar();
            } else {
                Nodo aux = inicio;

                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }

                aux.setSiguiente(null);
                cantElementos--;
            }
        }
    }

    @Override
    public void vaciar() {
        inicio = null;
        cantElementos = 0;
    }

    @Override
    public void mostrar() {

        if (!esVacia()) {
            Nodo aux = inicio;

            while (aux != null) {
                System.out.print(aux.getDato() + " - ");
                aux = aux.getSiguiente();
            }
        }
    }

    @Override
    public int cantElementos() {
        return cantElementos;
    }

    @Override
    public boolean existeElemento(T o) {
        Nodo aux = inicio;
        boolean existe = false;
        
        while (aux != null && !existe){
            if (aux.getDato().equals(o)){
                
            }
        }
        
        return existe;
    }
    
    public T obtenerPorObj(T o){
        T objeto = null;
        if (!esVacia()){
            Nodo aux = inicio;
            
            while(aux != null){
                if (aux.getDato().equals(o)){
                    objeto = aux.getDato();
                }
            }
        }
        return objeto;
    }
    
    @Override
    public T Obtener(int pos) {
        T objeto = null;
        if (!esVacia()) {
            Nodo<T> aux = inicio;
            for (int i = 0; i < pos; i++) {
                aux = aux.getSiguiente();
            }
            objeto = aux.getDato();
        }
        return objeto;
    }
    
    @Override
    public void eliminar(T n) {
        if (!esVacia()) {
            Nodo aux = inicio;

            while (aux != null) {
                if (aux.getSiguiente() == n && aux.getSiguiente() != null) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                }
                aux = aux.getSiguiente();
            }
        }
    }

}
