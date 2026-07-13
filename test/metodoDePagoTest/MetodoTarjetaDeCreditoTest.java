package metodoDePagoTest;

import org.junit.jupiter.api.*;

import metodoDePago.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

class MetodoTarjetaDeCreditoTest {

	private MetodoTarjetaDeCredito metodoTC; 
	private APITarjetaDeCredito tarjeta;
	private Cliente cliente;
	
	@BeforeEach 
	void setUp() {
		
		tarjeta = mock(APITarjetaDeCredito.class);
		cliente = mock(Cliente.class);
		
		metodoTC = new MetodoTarjetaDeCredito(cliente,tarjeta); 
		
	}
	
	@Test
	void procesarPagoExitoso() {

	    when(tarjeta.esTarjetaValida(cliente)).thenReturn(true);

	    metodoTC.procesarPago();

	    verify(tarjeta).preservarFondos(cliente);
	    verify(tarjeta).transferenciaInmediata(cliente);
	}
	
	@Test 
	void procesarPago() {
		
		when(tarjeta.esTarjetaValida(cliente)).thenReturn(false); 
		
		RuntimeException mensajeError = assertThrows(RuntimeException.class, () -> {metodoTC.procesarPago();});
		assertEquals("No es posible continuar, datos invalidos", mensajeError.getMessage());	
	}

	@Test
	void validarDatos() {
		
		metodoTC.validarDatos(cliente);
		verify(tarjeta).esTarjetaValida(cliente);
	}
	
	@Test 
	void reservarFondos() {
		
		metodoTC.reservarFondos(cliente);
		verify(tarjeta).preservarFondos(cliente);
	}
	
	@Test 
	void ejecutarTransaccion() {
		
		metodoTC.ejecutarTransaccion(cliente);
		verify(tarjeta).transferenciaInmediata(cliente);
	}
	
	@Test
	void notificar() {
		
		metodoTC.notificar(cliente);
	}
}