package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test3_04MapaDeEstaciones {

    private Retorno retorno;
    private final IObligatorio s = new Sistema();

    @Before
    public void setUp() {
        s.crearSistemaDeGestion();
    }

    @Test
    public void mapaOkEjemplo1() {
        String[][] mapa = {
            {"0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "E3", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0"},
            {"E1", "0", "0", "0", "E5", "0", "0"},
            {"0", "0", "E10", "0", "0", "0", "0"},
            {"0", "E2", "E11", "0", "0", "E6", "0"},
            {"0", "E9", "E12", "E7", "0", "0", "0"},
            {"0", "0", "0", "E4", "0", "0", "0"}
        };

        retorno = s.informaciónMapa(mapa);

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("3#ambas|existe", retorno.getValorString());
    }

    @Test
    public void mapaSinEstaciones() {
        String[][] mapa = {
            {"0", "0"},
            {"0", "0"}
        };

        retorno = s.informaciónMapa(mapa);

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("0#ambas|no existe", retorno.getValorString());
    }

    @Test
    public void mapaSoloFilas() {
        String[][] mapa = {
            {"E1", "E2", "E3"},
            {"0", "0", "E4"},
            {"0", "0", "0"}
        };

        retorno = s.informaciónMapa(mapa);

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("3#fila|no existe", retorno.getValorString());
    }

    @Test
    public void mapaAmbas() {
        String[][] mapa = {
            {"E1", "0", "E2"},
            {"E3", "0", "E4"},
            {"0", "E5", "E6"}
        };

        retorno = s.informaciónMapa(mapa);

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("3#columna|no existe", retorno.getValorString());
    }
}
