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

    @Override
    public Retorno crearSistemaDeGestion() {
        bicicletas = new ListaNodos<Bicicleta>();
        estaciones = new ListaNodos<Estacion>();
        usuarios = new ListaNodos<Usuario>();
        tiposBicicleta = new ListaNodos<String>();

        tiposBicicleta.agregarFinal("URBANA");
        tiposBicicleta.agregarFinal("MOUNTAIN");
        tiposBicicleta.agregarFinal("ELECTRICA");

        return Retorno.ok();
    }

    @Override
    public Retorno registrarEstacion(String nombre, String barrio, int capacidad) {

        if (nombre == null || nombre.isBlank()) {
            return Retorno.error1();
        }

        if (barrio == null || barrio.isBlank()) {
            return Retorno.error1();
        }

        if (capacidad <= 0) {
            return Retorno.error2();
        }

        Estacion estacionBuscada = new Estacion(nombre);

        if (estaciones.existeElemento(estacionBuscada)) {
            return Retorno.error3();
        }

        Estacion estacionNueva = new Estacion(nombre, barrio, capacidad);
        estaciones.agregarFinal(estacionNueva);
        return Retorno.ok();
    }

    @Override
    public Retorno registrarUsuario(String cedula, String nombre) {
        if (cedula == null || cedula.isBlank()) {
            return Retorno.error1();
        }

        if (nombre == null || nombre.isBlank()) {
            return Retorno.error1();
        }   

        if (cedula.length() != 8) {
            return Retorno.error2();
        }

        Usuario usuarioBuscado = new Usuario(cedula);
        if (usuarios.existeElemento(usuarioBuscado)){
            return Retorno.error3();
        }

        Usuario usuarioNuevo = new Usuario(cedula, nombre);
        usuarios.agregarFinal(usuarioNuevo);
        return Retorno.ok();
    }

    @Override
    public Retorno registrarBicicleta(String codigo, String tipo) {

        if (codigo == null || codigo.isBlank()) {
            return Retorno.error1();
        }

        if (tipo == null || tipo.isBlank()) {
            return Retorno.error1();
        }

        if (codigo.length() != 6) {
            return Retorno.error2();
        }

        if (!tiposBicicleta.existeElemento(tipo.toUpperCase())) {
            return Retorno.error3();
        }

        Bicicleta bicicletaBuscada = new Bicicleta(codigo);
        if (bicicletas.existeElemento(bicicletaBuscada)){
            return Retorno.error4();
        }

        Bicicleta bicicletaNueva = new Bicicleta(codigo, tipo);
        bicicletas.agregarFinal(bicicletaNueva);

        return Retorno.ok();
    }

    @Override
    public Retorno marcarEnMantenimiento(String codigo, String motivo) {
        if (codigo == null || codigo.isBlank() ) {
            return Retorno.error1();
        }

        if (motivo == null|| motivo.isBlank()) {
            return Retorno.error1();
        }

        Bicicleta aux = new Bicicleta(codigo);
        Bicicleta bicicletaBuscada = bicicletas.obtenerPorObj(aux);

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
        if (codigo == null || codigo.isBlank()) {
            return Retorno.error1();
        }

        Bicicleta aux = new Bicicleta(codigo);
        Bicicleta bicicletaBuscada = bicicletas.obtenerPorObj(aux);

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

        if (cedula == null || cedula.isBlank()) {
            return Retorno.error1();
        }

        if (cedula.length() != 8) {
            return Retorno.error2();
        }

        Usuario aux = new Usuario(cedula);
        Usuario usuarioBuscado = usuarios.obtenerPorObj(aux);

        if (usuarioBuscado == null) {
            return Retorno.error3();
        }
        
        String mensaje = usuarioBuscado.getNombre() + "#" + usuarioBuscado.getCedula();

        Retorno retorno = new Retorno(Retorno.Resultado.OK, mensaje);
        return retorno;
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
