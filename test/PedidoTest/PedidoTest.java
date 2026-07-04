package PedidoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import ItemCatalogo.*;
import Pedido.*;

class PedidoTest {
	
	private Pedido pedido; 
	private Paquete carrito;
	private ItemCatalogo p1;
	private EstadoPedido borrador;
	private EstadoPedido cancelado;
	
	@BeforeEach
	void setUp() {
		
		carrito = mock(Paquete.class);
		p1 = mock(Producto.class);
		
		borrador = new Borrador(pedido);
		cancelado = new Cancelado(pedido);
		
		pedido = new Pedido(null, carrito);
		
	}

	@Test
	void getYSetEstado() {
		
		pedido.setEstado(borrador);
		
		assertEquals(pedido.getEstado(), borrador);
		
		pedido.setEstado(cancelado);
		
		assertEquals(pedido.getEstado(), cancelado);
	}
	
	@Test
	void getCatalogo() {
		
		assertEquals(pedido.getCarrito(), carrito);
	}
	
	@Test
	void agregarYeliminarStock() {
		
		pedido.agregarProducto(p1);
		
		verify(carrito).addProducto(p1);
		
		pedido.eliminarProducto(p1);
		
		verify(carrito).deleteProducto(p1);
		
	}
	
	@Test
	void reponerStock() {
		
		pedido.reponerStock();
		
		verify(carrito).disminuirStock(1);
	}
	
	@Test
	void verificarCostos() {
		
		pedido.agregarProducto(p1);
		
		when(carrito.getPrecioFinal()).thenReturn(200.0);
		
		assertEquals(pedido.costoProductos(), 200.0);
	}

}
