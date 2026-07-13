package pedidoTest;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import itemCatalogo.*;
import metodoDeEnvio.*;
import metodoDePago.Cliente;
import metodoDePago.MetodoDePago;
import notificacionDePedido.ObservadorPedido;
import pedido.*;
import reporte.Venta;

class PedidoTest {
	
	private Pedido pedido; 
	private Paquete carrito;
	private ItemCatalogo p1;
	private EstadoPedido borrador;
	private EstadoPedido cancelado;
	private ObservadorPedido op1; 
	private Cliente cliente;
	private MetodoEnvio envio;
	private MetodoEnvio envio1;
	private MetodoDePago pago; 
	private MetodoDePago pago1; 
	private NotaDeCredito nota; 
	
	@BeforeEach
	void setUp() {
		
		carrito = mock(Paquete.class);
		p1 = mock(Producto.class);
		op1 = mock(ObservadorPedido.class);
		cliente = mock(Cliente.class);
		envio = mock(MetodoEnvio.class);
		envio1 = mock(EnvioEstandar.class);
		pago = mock(MetodoDePago.class);
		pago1 = mock(MetodoDePago.class);
		nota = mock(NotaDeCredito.class);
		
		pedido = new Pedido(null, carrito,cliente,envio,pago,nota);
		
		borrador = new Borrador(pedido);
		cancelado = new Cancelado(pedido);
		
	}
	
	@Test
	void reporteDeVentas() {

	    ArrayList<ItemCatalogo> items = new ArrayList<>();
	    items.add(p1);

	    when(carrito.getCatalogo()).thenReturn(items);
	    when(p1.getNombre()).thenReturn("Mouse");
	    when(p1.getPrecioBase()).thenReturn(1500.0);

	    ArrayList<Venta> ventas = pedido.reporteDeVentas();

	    assertEquals(1, ventas.size());

	    assertEquals("Mouse", ventas.get(0).getNombre());
	    assertEquals(1500.0, ventas.get(0).getPrecio());
	}
	
	@Test
	void notas() {
		
		pedido.generarNotaCredito();
		verify(nota).generarNotaCredito();
		pedido.generarNotaCreditoProductos();
		verify(nota).generarNotaCreditoProductos();
	}
	
	@Test
	void pago() {
		
		assertEquals(pedido.getMetodoPago(),pago);
		
		pedido.cambiarMetodoDePago(pago1);
		
		assertEquals(pedido.getMetodoPago(),pago1);
	}
		
	@Test
	void envio() {
				
		when(envio.costoEnvio(pedido)).thenReturn(500.0);		
		when(envio.diasDeEntrega(pedido)).thenReturn(5);
		
		assertEquals(pedido.costoDeEnvio(),500.0);
		assertEquals(pedido.diasDeEntrega(),5);
		assertEquals(pedido.getEnvio(),envio);
		
		pedido.setMetodoEnvio(envio1);
		
		assertEquals(pedido.getEnvio(), envio1);	
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
		
		pedido.disminuirStock();
		
		verify(carrito).disminuirStock(1);
		
	}
	
	@Test
	void cliente() {
		assertEquals(pedido.getCliente(),cliente);
	}
	
	@Test
	void verificarCostos() {
		
		pedido.agregarProducto(p1);
		
		when(carrito.getPrecioFinal()).thenReturn(200.0);
		
		assertEquals(pedido.costoProductos(), 200.0);
	}
	
	@Test
	void peso() {
		
		pedido.agregarProducto(p1);
		
		when(carrito.getPeso()).thenReturn(200);
		
		assertEquals(pedido.getPeso(),200);
	}
	
	@Test
	void observadores() {
		
		pedido.agregarObservador(op1);
		
		assertEquals(pedido.getObservadores().size(), 1); 
		
		pedido.eliminarObservador(op1);
		
		assertEquals(pedido.getObservadores().size(), 0); 		
	}
}
