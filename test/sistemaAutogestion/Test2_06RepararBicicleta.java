package sistemaAutogestion;

import dominio.Bicicleta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test2_06RepararBicicleta {

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
    public void repararBicicletaOk() {
        s.marcarEnMantenimiento("ABC123", "Falla en frenos");
        
        retorno = s.repararBicicleta("ABC123");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    public void repararBicicletaError01() {
        retorno = s.repararBicicleta("");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.repararBicicleta("   ");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.repararBicicleta(null);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
    }

    @Test
    public void repararBicicletaError02() {
        retorno = s.repararBicicleta("NOEXST");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
    }

    @Test
    public void repararBicicletaError03() {
        Bicicleta aux = new Bicicleta("XYZ999");
        Bicicleta bicicletaBuscada = ((Sistema) s).getBicicletas().obtenerPorObj(aux);

        bicicletaBuscada.SetEstado(Bicicleta.Estado.DISPONIBLE);

        retorno = s.repararBicicleta("XYZ999");
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
        
        bicicletaBuscada.SetEstado(Bicicleta.Estado.ALQUILADA);
        
        retorno = s.repararBicicleta("XYZ999");
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
    }
}
