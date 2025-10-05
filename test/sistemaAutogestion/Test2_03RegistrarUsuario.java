package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test2_03RegistrarUsuario {

    private Retorno retorno;
    private final IObligatorio s = new Sistema();

    @Before
    public void setUp() {
        s.crearSistemaDeGestion();
    }

    @Test
    public void registrarUsuarioOk() {
        retorno = s.registrarUsuario("12345678", "Juan Pérez");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    public void registrarUsuarioError01() {
        retorno = s.registrarUsuario("", "Juan");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.registrarUsuario(null, "Juan");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
        
        retorno = s.registrarUsuario("    ", "Juan");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.registrarUsuario("12345678", "");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.registrarUsuario("12345678", "   ");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.registrarUsuario("12345678", null);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
    }

    @Test
    public void registrarUsuarioError02() {
        retorno = s.registrarUsuario("1234567", "Santiago");  
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.registrarUsuario("123456789", "Santiago");  
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
    }

    @Test
    public void registrarUsuarioError03() {
        s.registrarUsuario("12345678", "Julian");
        retorno = s.registrarUsuario("12345678", "Juan");
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
    }
}
