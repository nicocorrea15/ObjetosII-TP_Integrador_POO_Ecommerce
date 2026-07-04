package PedidoTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import Pedido.*;

class CanceladoTest {
	
	private EstadoPedido cancelado;
	private Pedido pedido;
	
	@BeforeEach
	void setUp() {
		
		pedido = mock(Pedido.class);		
		cancelado = new Cancelado(pedido);
		
	}

	@Test
	void errorAgregar() {
		
		RuntimeException exAgregar = assertThrows(RuntimeException.class, () -> {cancelado.agregarProducto(null);});
		assertEquals("¡El pedido está cancelado!", exAgregar.getMessage());		
	}
	
	@Test
	void errorEliminar() {
		
		RuntimeException exEliminar = assertThrows(RuntimeException.class, () -> {cancelado.eliminarProducto(null);});
		assertEquals("¡El pedido está cancelado!", exEliminar.getMessage());
	}
	
	@Test
	void errorConfirmar() {
		
		RuntimeException exConfirmar = assertThrows(RuntimeException.class, cancelado::confirmar);
		assertEquals("¡El pedido está cancelado!", exConfirmar.getMessage());		
	}
	
	@Test
	void errorCancelado() {
		
		RuntimeException exCancelado = assertThrows(RuntimeException.class, cancelado::cancelado);
		assertEquals("¡El pedido está cancelado!", exCancelado.getMessage());		
	}
	
	@Test
	void errorPreparacion() {
		
		RuntimeException exPreparacion = assertThrows(RuntimeException.class, cancelado::enPreparacion);
		assertEquals("¡El pedido está cancelado!", exPreparacion.getMessage());	
	}
	
	@Test
	void errorEnviado() {
		
		RuntimeException exEnviado = assertThrows(RuntimeException.class, cancelado::enviado);
		assertEquals("¡El pedido está cancelado!", exEnviado.getMessage());		
	}
	
	@Test
	void errorEntregado() {
		
		RuntimeException exEntregado = assertThrows(RuntimeException.class, cancelado::entregado);
		assertEquals("¡El pedido está cancelado!", exEntregado.getMessage());		
	}
}







