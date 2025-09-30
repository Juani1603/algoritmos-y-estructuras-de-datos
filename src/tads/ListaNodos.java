package tads;

public class ListaNodos<T> implements ILista<T> {

    private Nodo inicio;
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

    public boolean existe(T n) {
        boolean existe = false;
        if (!esVacia()) {
            Nodo aux = inicio;

            while (aux != null) {
                existe = n.equals(aux.getDato());
                aux = aux.getSiguiente();
            }
        }
        return existe;
    }
    
    public T buscarElemento(String clave){
        if (!esVacia()){
            Nodo<T> aux = inicio;
            
            while (aux != null){
                if (clave.equals(aux.getDato())){
                    return aux.getDato();
                }
                aux = aux.getSiguiente();
            }
        }   
        return null;
    }
    
    public void eliminar(T n) {
        if (!esVacia()) {
            Nodo aux = inicio;

            while (aux != null) {
                if (aux.getSiguiente() == n && aux.getSiguiente() != null){
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                }
                aux = aux.getSiguiente();
            }
        }
    }
}
