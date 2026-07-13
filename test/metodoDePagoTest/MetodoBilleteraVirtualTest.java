package metodoDePagoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import metodoDePago.*;

class MetodoBilleteraVirtualTest {
	
	private MetodoBilleteraVirtual metodoBV; 
	private APIBilleteraVirtual billeVirtual;
	private Cliente cliente;
	
	@BeforeEach 
	void setUp() {
		
		billeVirtual = mock(APIBilleteraVirtual.class);
		cliente = mock(Cliente.class);
		
		metodoBV = new MetodoBilleteraVirtual(cliente,billeVirtual); 
		
	}
	
	@Test
	void procesarPagoExitoso() {

	    when(billeVirtual.tieneSaldo(cliente)).thenReturn(true);

	    metodoBV.procesarPago();

	    verify(billeVirtual).bloquearSaldo(cliente);
	    verify(billeVirtual).acreditarAlDestinatario(cliente);
	}
	
	@Test 
	void procesarPago() {
		
		when(billeVirtual.tieneSaldo(cliente)).thenReturn(false); 
		
		RuntimeException mensajeError = assertThrows(RuntimeException.class, () -> {metodoBV.procesarPago();});
		assertEquals("No es posible continuar, datos invalidos", mensajeError.getMessage());	
	}

	@Test
	void validarDatos() {
		
		metodoBV.validarDatos(cliente);
		verify(billeVirtual).tieneSaldo(cliente);
	}
	
	@Test 
	void reservarFondos() {
		
		metodoBV.reservarFondos(cliente);
		verify(billeVirtual).bloquearSaldo(cliente);
	}
	
	@Test 
	void ejecutarTransaccion() {
		
		metodoBV.ejecutarTransaccion(cliente);
		verify(billeVirtual).acreditarAlDestinatario(cliente);
	}
	
	@Test
	void notificar() {
		
		metodoBV.notificar(cliente);
	}
}