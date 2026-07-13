package pedidoTest;

import  org.junit.jupiter.api.*;

import pedido.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

class EntregadoTest {
	
	private EstadoPedido entregado; 
	private Pedido pedido;
	
	@BeforeEach
	void setUp() {
		
		pedido = mock(Pedido.class);
		entregado = new Entregado(pedido);
	}
	
	@Test 
	void nombre() {
		assertEquals(entregado.getEstadoString(), "Entregado");
	}

	@Test
	void errorAgregar() {
		
		RuntimeException exAgregar = assertThrows(RuntimeException.class, () -> {entregado.agregarProducto(null);});
		assertEquals("¡El producto ya fue entregado!", exAgregar.getMessage());		
	}
	
	@Test
	void errorEliminar() {
		
		RuntimeException exEliminar = assertThrows(RuntimeException.class, () -> {entregado.eliminarProducto(null);});
		assertEquals("¡El producto ya fue entregado!", exEliminar.getMessage());		
	}
	
	@Test
	void errorConfirmar() {
		
		RuntimeException exConfirmar = assertThrows(RuntimeException.class, entregado::confirmar);
		assertEquals("¡El producto ya fue entregado!", exConfirmar.getMessage());		
	}
	
	@Test
	void errorCancelado() {
		
		RuntimeException exCancelado = assertThrows(RuntimeException.class, entregado::cancelado);
		assertEquals("¡El producto ya fue entregado!", exCancelado.getMessage());		
	}
	
	@Test
	void errorPreparacion() {
		
		RuntimeException exPreparacion = assertThrows(RuntimeException.class, entregado::enPreparacion);
		assertEquals("¡El producto ya fue entregado!", exPreparacion.getMessage());	
	}
	
	@Test
	void errorEnviado() {
		
		RuntimeException exEnviado = assertThrows(RuntimeException.class, entregado::enviado);
		assertEquals("¡El producto ya fue entregado!", exEnviado.getMessage());		
	}
	
	@Test
	void errorEntregado() {
		
		RuntimeException exEntregado = assertThrows(RuntimeException.class, entregado::entregado);
		assertEquals("¡El producto ya fue entregado!", exEntregado.getMessage());		
	}

}
