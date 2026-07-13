package pedidoTest;

import org.junit.jupiter.api.*;

import pedido.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EnPreparacionTest {

	private EstadoPedido preparacion; 
	private Pedido pedido;
	
	@BeforeEach
	void setUp() {
		
		pedido = mock(Pedido.class);
		preparacion = new EnPreparacion(pedido);
	}
	
	@Test 
	void nombre() {
		assertEquals(preparacion.getEstadoString(), "EnPreparacion");
	}
	
	@Test
	void errorAgregar() {
		
		RuntimeException exAgregar = assertThrows(RuntimeException.class, () -> {preparacion.agregarProducto(null);});
		assertEquals("¡El pedido se esta preparando!", exAgregar.getMessage());		
	}
	
	@Test
	void errorEliminar() {
		
		RuntimeException exEliminar = assertThrows(RuntimeException.class, () -> {preparacion.eliminarProducto(null);});
		assertEquals("¡El pedido se esta preparando!", exEliminar.getMessage());		
	}
	
	@Test
	void errorConfirmar() {
		
		RuntimeException exConfirmar = assertThrows(RuntimeException.class, preparacion::confirmar);
		assertEquals("¡El pedido se esta preparando!", exConfirmar.getMessage());		
	}
	
	@Test 
	void cancelado() {
		
		preparacion.cancelado();
		verify(pedido).reponerStock();
		verify(pedido).generarNotaCredito();
		verify(pedido).setEstado(any(Cancelado.class));
	}
	
	@Test 
	void enviado() {
		
		preparacion.enviado();
		verify(pedido).setEstado(any(Enviado.class));
	}
	
	@Test
	void errorEnPreparacion() {
		
		RuntimeException exPreparacion = assertThrows(RuntimeException.class, preparacion::enPreparacion);
		assertEquals("¡El pedido se esta preparando!", exPreparacion.getMessage());		
	}
	
	@Test
	void errorEntregado() {
		
		RuntimeException exEntregado = assertThrows(RuntimeException.class, preparacion::entregado);
		assertEquals("¡El pedido se esta preparando!", exEntregado.getMessage());		
	}

	
	
}
