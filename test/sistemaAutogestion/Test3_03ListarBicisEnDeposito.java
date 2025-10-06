package sistemaAutogestion;

import dominio.Bicicleta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test3_03ListarBicisEnDeposito {

    private Retorno retorno;
    private final IObligatorio s = new Sistema();

    @Before
    public void setUp() {
        s.crearSistemaDeGestion();
    }

    @Test
    public void listarBicisVacio() {
        retorno = s.listarBicisEnDeposito();
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("", retorno.getValorString());
    }

    @Test
    public void listarBicisUnaSola() {
        s.registrarBicicleta("ABC123", "URBANA");

        retorno = s.listarBicisEnDeposito();
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("ABC123#URBANA#DISPONIBLE", retorno.getValorString());
    }

    @Test
    public void listarBicisMultiples() {
        s.registrarBicicleta("AER345", "URBANA");
        s.registrarBicicleta("UTR112", "ELECTRICA");
        s.registrarBicicleta("MNT999", "MOUNTAIN");

        s.marcarEnMantenimiento("UTR112", "Revisión general");

        retorno = s.listarBicisEnDeposito();
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        assertEquals("AER345#URBANA#DISPONIBLE|UTR112#ELECTRICA#MANTENIMIENTO|MNT999#MOUNTAIN#DISPONIBLE", retorno.getValorString()
        );
    }

    @Test
    public void listarBicisSoloEnDeposito() {
        s.registrarBicicleta("ABC111", "URBANA");
        s.registrarBicicleta("XYZ222", "MOUNTAIN");
        s.registrarBicicleta("ELE333", "ELECTRICA");

        Bicicleta aux = new Bicicleta("XYZ222");
        Bicicleta bicicletaBuscada = ((Sistema) s).getBicicletas().obtenerPorObj(aux);
        bicicletaBuscada.SetEstado(Bicicleta.Estado.ALQUILADA);

        retorno = s.listarBicisEnDeposito();
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        assertEquals("ABC111#URBANA#DISPONIBLE|ELE333#ELECTRICA#DISPONIBLE",retorno.getValorString());
    }
}
