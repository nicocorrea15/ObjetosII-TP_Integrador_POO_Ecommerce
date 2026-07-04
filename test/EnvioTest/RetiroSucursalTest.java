package EnvioTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import Envio.*;
import Pedido.*;

class RetiroSucursalTest {
	
	private RetiroEnSucursal envio;
	private Pedido pedido;
	private Sucursal sucursal;
	
	@BeforeEach
	void setUp() {
		
		pedido = mock(Pedido.class);
		sucursal = mock(Sucursal.class);
		
		envio = new RetiroEnSucursal(pedido,sucursal);
	}

	@Test
	void costoEnvio() {
		
		assertTrue(envio.costoEnvio() == 0);
	}
	
	@Test
	void diasEntregaHayStock() {
		
		when(sucursal.tieneStock(pedido)).thenReturn(true);
		assertEquals(envio.diasDeEntrega(),0);
	}
	
	@Test
	void diasEntregaNoHayStock() {
		
		when(sucursal.tieneStock(pedido)).thenReturn(false);
		when(sucursal.tardanzaEntrega()).thenReturn(2);
		
		assertEquals(envio.diasDeEntrega(),2);
		
		when(sucursal.tardanzaEntrega()).thenReturn(3);
		assertEquals(envio.diasDeEntrega(),3);
	}

}
