package EnvioTest;

import  org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import Envio.*;
import Pedido.*;

class EnvioExpressTest {
	
	private EnvioExpress envio;
	private Pedido pedido;
	
	@BeforeEach
	void setUp() {
		
		pedido = mock(Pedido.class);
		
		envio = new EnvioExpress(pedido,300,0.15);
	}

	@Test
	void costoEnvio() {
		
		when(pedido.costoProductos()).thenReturn(15000.0);
		
		assertTrue(envio.costoEnvio() == 2550);
	}
	
	@Test
	void diasDeEntrega() {
		
		assertEquals(envio.diasDeEntrega(),1);
	}

}
