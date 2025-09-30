package dominio;

import tads.*;

public class Estacion {

    private String nombre;
    private String barrio;
    private int capacidad;
    ListaNodos<Anclaje> anclajes;

    public Estacion(String nombre, String barrio, int capacidad) {
        this.nombre = nombre;
        this.barrio = barrio;
        this.capacidad = capacidad;
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
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Estacion estacion = (Estacion) o;
        return this.nombre == estacion.nombre && nombre.equals(estacion.nombre);
    }
}
