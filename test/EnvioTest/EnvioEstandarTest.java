package EnvioTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import Envio.*;
import Pedido.*;

class EnvioEstandarTest {
	
	private EnvioEstandar envio;
	private Pedido pedido;
	private Direccion dir;
	private Correo correo;
	
	@BeforeEach
	void setUp() {
		
		pedido = mock(Pedido.class);
		dir = mock(Direccion.class);
		correo = mock(Correo.class);
		
		envio = new EnvioEstandar(pedido,dir,correo);
	}

	@Test
	void direccion() {
		
		assertEquals(envio.getDir(), dir);
	}
	
	@Test
	void costoEnvio() {
		
		when(correo.estimarEnvio(pedido.getPeso(), dir)).thenReturn((float) 500);
		assertTrue(envio.costoEnvio() == (float) 500);
	}
	
	@Test
	void diasDeEntrega() {
		
		when(correo.diasDeEntrega(dir)).thenReturn(10);
		assertEquals(envio.diasDeEntrega(),10);
	}

}
