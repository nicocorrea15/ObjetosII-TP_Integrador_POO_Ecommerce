package metodoDePagoTest;

import org.junit.jupiter.api.*;

import metodoDePago.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

class MetodoTransferenciaBancariaTest {

	private MetodoTransferenciaBancaria metodoTB; 
	private APIBanco banco;
	private Cliente cliente;
	
	@BeforeEach 
	void setUp() {
		
		banco = mock(APIBanco.class);
		cliente = mock(Cliente.class);
		
		metodoTB = new MetodoTransferenciaBancaria(cliente,banco); 
		
	}
	
	@Test
	void procesarPagoExitoso() {

	    when(banco.esBancoValido(cliente)).thenReturn(true);

	    metodoTB.procesarPago();

	    verify(banco).transferir(cliente);
	}
	
	@Test 
	void procesarPago() {
		
		when(banco.esBancoValido(cliente)).thenReturn(false); 
		
		RuntimeException mensajeError = assertThrows(RuntimeException.class, () -> {metodoTB.procesarPago();});
		assertEquals("No es posible continuar, datos invalidos", mensajeError.getMessage());	
	}

	@Test
	void validarDatos() {
		
		metodoTB.validarDatos(cliente);
		verify(banco).esBancoValido(cliente);
	}
	
	@Test 
	void reservarFondos() {
		
		metodoTB.reservarFondos(cliente);
	}
	
	@Test 
	void ejecutarTransaccion() {
		
		metodoTB.ejecutarTransaccion(cliente);
		verify(banco).transferir(cliente);
	}
	
	@Test
	void notificar() {
		
		metodoTB.notificar(cliente);
	}
}

