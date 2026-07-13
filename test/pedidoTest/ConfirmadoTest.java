package pedidoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import pedido.*;

class ConfirmadoTest {
	
	private EstadoPedido confirmado; 
	private Pedido pedido;
	
	@BeforeEach
	void setUp() {
		
		pedido = mock(Pedido.class);
		confirmado = new Confirmado(pedido);
	}
	
	@Test 
	void nombre() {
		assertEquals(confirmado.getEstadoString(), "Confirmado");
	}

	@Test
	void errorAgregar() {
		
		RuntimeException exAgregar = assertThrows(RuntimeException.class,
				() -> {confirmado.agregarProducto(null);});
		assertEquals("No es posible agregar productos en este estado", exAgregar.getMessage());	
	}
	
	@Test
	void errorEliminar() {
		
		RuntimeException exEliminar = assertThrows(RuntimeException.class, 
				() -> {confirmado.eliminarProducto(null);});
		assertEquals("No es posible eliminar productos en este estado", exEliminar.getMessage());		
	}
	
	@Test
	void errorConfirmar() {
		
		RuntimeException exConfirmar = assertThrows(RuntimeException.class, confirmado::confirmar);
		assertEquals("Ya estamos en este estado", exConfirmar.getMessage());		
	}
	
	@Test 
	void cancelado() {
		
		confirmado.cancelado();
		verify(pedido).reponerStock();
		verify(pedido).setEstado(any(Cancelado.class));
	}
	
	@Test
	void errorEnEnviado() {
		
		RuntimeException exEnviado = assertThrows(RuntimeException.class, confirmado::enviado);
		assertEquals("No es posible enviar en este estado", exEnviado.getMessage());
	}
	
	@Test 
	void enPreparacion() {
		
		confirmado.enPreparacion();
		verify(pedido).setEstado(any(EnPreparacion.class));
	}
	
	@Test
	void errorEntregado() {
		
		RuntimeException exEntregado = assertThrows(RuntimeException.class, confirmado::entregado);
		assertEquals("No es posible enviar en este estado", exEntregado.getMessage());		
	}
	
	

}
