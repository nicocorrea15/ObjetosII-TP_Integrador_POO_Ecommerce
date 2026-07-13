package envioTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import metodoDeEnvio.*;
import pedido.*;

class RetiroSucursalTest {
	
	private RetiroEnSucursal envio;
	private Pedido pedido;
	private Sucursal sucursal;
	
	@BeforeEach
	void setUp() {
		
		pedido = mock(Pedido.class);
		sucursal = mock(Sucursal.class);
		
		envio = new RetiroEnSucursal(sucursal);
	}

	@Test
	void costoEnvio() {
		
		assertTrue(envio.costoEnvio(pedido) == 0);
	}
	
	@Test
	void diasEntregaHayStock() {
		
		when(sucursal.tieneStock(pedido)).thenReturn(true);
		assertEquals(envio.diasDeEntrega(pedido),0);
	}
	
	@Test
	void diasEntregaNoHayStock() {
		
		when(sucursal.tieneStock(pedido)).thenReturn(false);
		when(sucursal.tardanzaEntrega()).thenReturn(2);
		
		assertEquals(envio.diasDeEntrega(pedido),2);
		
		when(sucursal.tardanzaEntrega()).thenReturn(3);
		assertEquals(envio.diasDeEntrega(pedido),3);
	}

}
