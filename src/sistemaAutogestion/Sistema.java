package sistemaAutogestion;

import tads.*;
import dominio.*;
//Juan Triunfo - 230039
//Julian Schenck - 352207

public class Sistema implements IObligatorio {

    private ListaNodos<Bicicleta> bicicletas;
    private ListaNodos<Estacion> estaciones;
    private ListaNodos<Usuario> usuarios;
    private ListaNodos<String> tiposBicicleta;

    public Sistema() {
        this.bicicletas = new ListaNodos<Bicicleta>();
        this.estaciones = new ListaNodos<Estacion>();
        this.usuarios = new ListaNodos<Usuario>();
        this.tiposBicicleta = new ListaNodos<String>();

        tiposBicicleta.agregarFinal("URBANA");
        tiposBicicleta.agregarFinal("MOUNTAIN");
        tiposBicicleta.agregarFinal("ELECTRICA");
    }

    @Override
    public Retorno crearSistemaDeGestion() {

        return Retorno.ok();
    }

    @Override
    public Retorno registrarEstacion(String nombre, String barrio, int capacidad) {

        if (nombre == null || barrio == null) {
            return Retorno.error1();
        }

        if (nombre.isBlank() || barrio.isBlank()) {
            return Retorno.error1();
        }

        if (capacidad <= 0) {
            return Retorno.error2();
        }

        Estacion estacionBuscada = estaciones.buscarElemento(nombre);
        if (estacionBuscada != null) {
            return Retorno.error3();
        }

        Estacion estacionNueva = new Estacion(nombre, barrio, capacidad);
        estaciones.agregarFinal(estacionNueva);
        return Retorno.ok();
    }

    @Override
    public Retorno registrarUsuario(String cedula, String nombre) {
        if (cedula == null || nombre == null) {
            return Retorno.error1();
        }

        if (cedula.isBlank() || nombre.isBlank()) {
            return Retorno.error1();
        }

        if (cedula.length() != 8) {
            return Retorno.error2();
        }

        Usuario usuarioBuscado = usuarios.buscarElemento(cedula);
        if (usuarioBuscado != null) {
            return Retorno.error3();
        }

        Usuario usuarioNuevo = new Usuario(cedula, nombre);
        usuarios.agregarFinal(usuarioNuevo);
        return Retorno.ok();
    }

    @Override
    public Retorno registrarBicicleta(String codigo, String tipo) {

        if (codigo == null || tipo == null){
            return Retorno.error1();
        }
        
        if (codigo.isBlank() || tipo.isBlank()){
            return Retorno.error1();
        }

        if (codigo.length() != 6) {
            return Retorno.error2();
        }

        if (!tiposBicicleta.existe(tipo.toUpperCase())) {
            return Retorno.error3();
        }

        Bicicleta bicicletaBuscada = bicicletas.buscarElemento(codigo);
        if (bicicletaBuscada != null) {
            return Retorno.error4();
        }

        Bicicleta bicicletaNueva = new Bicicleta(codigo, tipo);
        bicicletas.agregarFinal(bicicletaNueva);

        return Retorno.ok();
    }

    @Override
    public Retorno marcarEnMantenimiento(String codigo, String motivo) {
        if (codigo == null || motivo == null){
            return Retorno.error1();
        }
        
        if (codigo.isBlank() || motivo.isBlank()){
            return Retorno.error1();
        }

        Bicicleta bicicletaBuscada = bicicletas.buscarElemento(codigo);
        if (bicicletaBuscada == null) {
            return Retorno.error2();
        }

        if (bicicletaBuscada.getEstado() == Bicicleta.Estado.ALQUILADA) {
            return Retorno.error3();
        }

        if (bicicletaBuscada.getEstado() == Bicicleta.Estado.MANTENIMIENTO) {
            return Retorno.error4();
        }

        bicicletaBuscada.SetEstado(Bicicleta.Estado.MANTENIMIENTO);
        return Retorno.ok();
    }

    @Override
    public Retorno repararBicicleta(String codigo) {
        if (codigo == null) {
            return Retorno.error1();
        }
        
        if (codigo.isBlank()){
            return Retorno.error1();
        }

        Bicicleta bicicletaBuscada = bicicletas.buscarElemento(codigo);

        if (bicicletaBuscada == null) {
            return Retorno.error2();
        }

        if (bicicletaBuscada.getEstado() != Bicicleta.Estado.MANTENIMIENTO) {
            return Retorno.error3();
        }

        bicicletaBuscada.SetEstado(Bicicleta.Estado.DISPONIBLE);
        return Retorno.ok();
    }

    @Override
    public Retorno eliminarEstacion(String nombre) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno asignarBicicletaAEstacion(String codigo, String nombreEstacion) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno alquilarBicicleta(String cedula, String nombreEstacion) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno devolverBicicleta(String cedula, String nombreEstacionDestino) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno deshacerUltimosRetiros(int n) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno obtenerUsuario(String cedula) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarUsuarios() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarBicisEnDeposito() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno informaciónMapa(String[][] mapa) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarBicicletasDeEstacion(String nombreEstacion) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno estacionesConDisponibilidad(int n) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno ocupacionPromedioXBarrio() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno rankingTiposPorUso() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno usuariosEnEspera(String nombreEstacion) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno usuarioMayor() {
        return Retorno.noImplementada();
    }

}
