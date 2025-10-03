package dominio;

import tads.*;

public class Estacion implements Comparable<Estacion>{

    private String nombre;
    private String barrio;
    private int capacidad;
    ListaNodos<Anclaje> anclajes;

    public Estacion(String nombre, String barrio, int capacidad) {
        this.nombre = nombre;
        this.barrio = barrio;
        this.capacidad = capacidad;
    }

    public Estacion(String nombre) {
        this.nombre = nombre;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ListaNodos<Anclaje> getAnclajes() {
        return anclajes;
    }

    public void setAnclajes(ListaNodos<Anclaje> anclajes) {
        this.anclajes = anclajes;
    }

    @Override
    public boolean equals(Object o) {
        return this.getNombre().equalsIgnoreCase(((Estacion)o).getNombre());
    }

    @Override
    public int compareTo(Estacion o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
