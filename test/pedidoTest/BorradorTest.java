package pedidoTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import itemCatalogo.*;
import pedido.*;

class BorradorTest {
	
	private EstadoPedido borrador;
	private Pedido pedido;
	private ItemCatalogo p1;
	
	@BeforeEach
	void setUp() {
		
		pedido = mock(Pedido.class);
		
		p1 = mock(ItemCatalogo.class);
		
		borrador = new Borrador(pedido);
		
	}
	
	@Test 
	void nombre() {
		assertEquals(borrador.getEstadoString(), "Borrador");
	}

	@Test
	void agregarYEliminar() {
		
		borrador.agregarProducto(p1);
		verify(pedido).agregarProducto(p1);
		
		borrador.eliminarProducto(p1);
		verify(pedido).eliminarProducto(p1);
	}
	
	@Test
	void confirmar() {
		
		borrador.confirmar();
		verify(pedido).disminuirStock();
		verify(pedido).setEstado(any(Confirmado.class));
	}
	
	@Test 
	void cancelado() {
		
		borrador.cancelado();
		verify(pedido).setEstado(any(Cancelado.class));
	}
	
	@Test
	void errorEnEnviado() {
		
		RuntimeException exEnviado = assertThrows(RuntimeException.class, borrador::enviado);
		assertEquals("No es posible enviar todavia", exEnviado.getMessage());
	}
	
	@Test
	void errorEnPreparacion() {
		
		RuntimeException exPreparacion = assertThrows(RuntimeException.class, borrador::enPreparacion);
		assertEquals("No es posible pasar a preparacion en este estado", exPreparacion.getMessage());
	}
	
	@Test
	void errorEnEntregado() {
		
		RuntimeException exEntregado = assertThrows(RuntimeException.class, borrador::entregado);
		assertEquals("No es posible entregar en este estado", exEntregado.getMessage());
	}
}
