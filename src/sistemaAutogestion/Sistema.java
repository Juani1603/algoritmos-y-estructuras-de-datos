package sistemaAutogestion;

import tads.*;
import dominio.*;
//Juan Triunfo - 230039
//Julian Schenck - 352207

public class Sistema implements IObligatorio {

    private ListaNodos<Bicicleta> bicicletasEnDeposito;
    private ListaNodos<Estacion> estaciones;
    private ListaNodos<Usuario> usuarios;
    private ListaNodos<String> tiposBicicleta;

    public ListaNodos<Bicicleta> getBicicletas() {
        return bicicletasEnDeposito;
    }

    public Sistema() {
        bicicletasEnDeposito = new ListaNodos<Bicicleta>();
        estaciones = new ListaNodos<Estacion>();
        usuarios = new ListaNodos<Usuario>();
        tiposBicicleta = new ListaNodos<String>();
    }

    @Override
    public Retorno crearSistemaDeGestion() {
        bicicletasEnDeposito = new ListaNodos<Bicicleta>();
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
        if (usuarios.existeElemento(usuarioBuscado)) {
            return Retorno.error3();
        }

        Usuario usuarioNuevo = new Usuario(cedula, nombre);
        usuarios.agregarOrdenado(usuarioNuevo);
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
        if (bicicletasEnDeposito.existeElemento(bicicletaBuscada)) {
            return Retorno.error4();
        }

        Bicicleta bicicletaNueva = new Bicicleta(codigo, tipo);
        bicicletasEnDeposito.agregarFinal(bicicletaNueva);

        return Retorno.ok();
    }

    @Override
    public Retorno marcarEnMantenimiento(String codigo, String motivo) {
        if (codigo == null || codigo.isBlank()) {
            return Retorno.error1();
        }

        if (motivo == null || motivo.isBlank()) {
            return Retorno.error1();
        }

        Bicicleta aux = new Bicicleta(codigo);
        Bicicleta bicicletaBuscada = bicicletasEnDeposito.obtenerPorObj(aux);

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
        Bicicleta bicicletaBuscada = bicicletasEnDeposito.obtenerPorObj(aux);

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
        String mensaje = "";

        for (int i = 0; i < usuarios.cantElementos(); i++) {
            Usuario u = usuarios.obtenerPorPos(i);
            mensaje += usuarios.obtenerPorObj(u);
            if (i != usuarios.cantElementos() - 1) {
                mensaje += "|";
            }

        }

        Retorno retorno = new Retorno(Retorno.Resultado.OK, mensaje);
        return retorno;
    }

    @Override
    public Retorno listarBicisEnDeposito() {
        String mensaje = "";

        for (int i = 0; i < bicicletasEnDeposito.cantElementos(); i++) {
            Bicicleta b = bicicletasEnDeposito.obtenerPorPos(i);
            if (b.getEstado() != Bicicleta.Estado.ALQUILADA) {
                mensaje += b.getCodigo() + "#" + b.getTipo() + "#" + b.getEstado();
                if (i != bicicletasEnDeposito.cantElementos() - 1) {
                    mensaje += "|";
                }
            }
        }

        Retorno retorno = new Retorno(Retorno.Resultado.OK, mensaje);
        return retorno;
    }

    @Override
    public Retorno informaciónMapa(String[][] mapa) {
        int maxEstacionesFila = 0;

        for (int i = 0; i < mapa.length; i++) {
            int cantEstacionesFila = 0;
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] != "0") {
                    cantEstacionesFila++;
                }
            }
            if (cantEstacionesFila > maxEstacionesFila) {
                maxEstacionesFila = cantEstacionesFila;
            }
        }

        int maxEstacionesColumna = 0;
        int estacionesColumnaAnterior = 0;
        int estacionesConsecutivas = 0;
        boolean existenConsecutivas = false;

        for (int j = 0; j < mapa[0].length; j++) {
            int cantEstacionesColumna = 0;
            for (int i = 0; i < mapa.length; i++) {
                if (mapa[i][j] != "0") {
                    cantEstacionesColumna++;
                }
            }

            if (cantEstacionesColumna > maxEstacionesColumna) {
                maxEstacionesColumna = cantEstacionesColumna;
            }

            if (cantEstacionesColumna > estacionesColumnaAnterior && !existenConsecutivas) {
                estacionesConsecutivas++;
            } else {
                estacionesConsecutivas = 0;
            }

            if (estacionesConsecutivas >= 3) {
                existenConsecutivas = true;
            }

            estacionesColumnaAnterior = cantEstacionesColumna;
        }

        String mensaje = "";

        if (maxEstacionesFila > maxEstacionesColumna) {
            mensaje += maxEstacionesFila + "#fila";
        } else if (maxEstacionesFila < maxEstacionesColumna) {
            mensaje += maxEstacionesColumna + "#columna";
        } else {
            mensaje += maxEstacionesFila + "#ambas";
        }

        if (existenConsecutivas) {
            mensaje += "|existe";
        } else {
            mensaje += "|no existe";
        }

        Retorno retorno = new Retorno(Retorno.Resultado.OK, mensaje);
        return retorno;
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
