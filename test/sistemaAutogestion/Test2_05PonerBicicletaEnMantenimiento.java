package sistemaAutogestion;

import dominio.Bicicleta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test2_05PonerBicicletaEnMantenimiento {

    private Retorno retorno;
    private final IObligatorio s = new Sistema();

    @Before
    public void setUp() {
        s.crearSistemaDeGestion();
        s.registrarBicicleta("ABC123", "URBANA");
        s.registrarBicicleta("XYZ999", "MOUNTAIN");
        s.registrarBicicleta("ELE456", "ELECTRICA");
    }

    @Test
    public void marcarEnMantenimientoOk() {
        retorno = s.marcarEnMantenimiento("ABC123", "Pinchazo en rueda trasera");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    public void marcarEnMantenimientoError01() {
        retorno = s.marcarEnMantenimiento("", "Motivo cualquiera");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("   ", "Motivo cualquiera");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.marcarEnMantenimiento(null, "Motivo cualquiera");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("ABC123", "");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("ABC123", "   ");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.marcarEnMantenimiento("ABC123", null);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
    }

    @Test
    public void marcarEnMantenimientoError02() {
        retorno = s.marcarEnMantenimiento("NOEXST", "Frenos dañados");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
    }

    @Test
    public void marcarEnMantenimientoError03() {
        Bicicleta aux = new Bicicleta("ABC123");
        Bicicleta bicicletaBuscada = ((Sistema) s).getBicicletas().obtenerPorObj(aux);

        bicicletaBuscada.SetEstado(Bicicleta.Estado.ALQUILADA);

        retorno = s.marcarEnMantenimiento("ABC123", "Fallo");
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
    }

    @Test
    public void marcarEnMantenimientoError04() {
        Bicicleta aux = new Bicicleta("ABC123");
        Bicicleta bicicletaBuscada = ((Sistema) s).getBicicletas().obtenerPorObj(aux);

        bicicletaBuscada.SetEstado(Bicicleta.Estado.MANTENIMIENTO);

        retorno = s.marcarEnMantenimiento("ABC123", "Revisión");
        assertEquals(Retorno.Resultado.ERROR_4, retorno.getResultado());
    }
}
