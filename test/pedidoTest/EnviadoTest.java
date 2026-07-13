package pedidoTest;

import static org.junit.Assert.*;
import  org.junit.jupiter.api.*;

import pedido.*;

import static org.mockito.Mockito.*;

class EnviadoTest {
	
	private EstadoPedido enviado;
	private Pedido pedido;
	
	@BeforeEach
	void setUp() {
		
		pedido = mock(Pedido.class);		
		enviado = new Enviado(pedido);
		
	}
	
	@Test 
	void nombre() {
		assertEquals(enviado.getEstadoString(), "Enviado");
	}

	@Test
	void errorAgregar() {
		
		RuntimeException exAgregar = assertThrows(RuntimeException.class, () -> {enviado.agregarProducto(null);});
		assertEquals("¡El producto ya fue enviado!", exAgregar.getMessage());		
	}
	
	@Test
	void errorEliminar() {
		
		RuntimeException exEliminar = assertThrows(RuntimeException.class, () -> {enviado.eliminarProducto(null);});
		assertEquals("¡El producto ya fue enviado!", exEliminar.getMessage());		
	}
	
	@Test
	void errorConfirmar() {
		
		RuntimeException exConfirmar = assertThrows(RuntimeException.class, enviado::confirmar);
		assertEquals("¡El producto ya fue enviado!", exConfirmar.getMessage());		
	}
	
	@Test
	void cancelado() {
		
		enviado.cancelado();
		verify(pedido).setEstado(any(Cancelado.class));
		verify(pedido).generarNotaCreditoProductos();
	}
	
	@Test
	void errorPreparacion() {
		
		RuntimeException exPreparacion = assertThrows(RuntimeException.class, enviado::enPreparacion);
		assertEquals("¡El producto ya fue enviado!", exPreparacion.getMessage());	
	}
	
	@Test
	void errorEnviado() {
		
		RuntimeException exEnviado = assertThrows(RuntimeException.class, enviado::enviado);
		assertEquals("¡El producto ya fue enviado!", exEnviado.getMessage());		
	}
	
	@Test
	void entregado() {
		
		enviado.entregado();
		verify(pedido).setEstado(any(Entregado.class));
			
	}

}
