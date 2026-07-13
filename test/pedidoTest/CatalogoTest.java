package pedidoTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import busquedaCatalogo.*;
import itemCatalogo.*;
import pedido.*;
import reporte.Venta;

class CatalogoTest {
	
	private Catalogo catalogo;
	private ItemCatalogo it; 
	private ItemCatalogo it2; 
	private CriterioBusqueda cb; 
	private CriterioBusqueda cb2; 
	private CriterioBusqueda cb3; 
	private CriterioBusqueda cb4; 
	
	@BeforeEach
	void setUp() {
		
		it = mock(ItemCatalogo.class);
		it2 = mock(ItemCatalogo.class); 
		
		cb = mock(CriterioBusqueda.class);
		cb2 = mock(CriterioBusqueda.class);
		cb3 = mock(CriterioBusqueda.class);
		cb4 = mock(CriterioBusqueda.class);
		
		catalogo = new Catalogo(); 
	}

	@Test
	void agregarYEliminar() {
		
		catalogo.agregarItem(it);
		
		assertTrue(catalogo.getCatalogo().contains(it)); 
		
		catalogo.eliminarItem(it);
		
		assertFalse(catalogo.getCatalogo().contains(it));
		
	}
	
	@Test
	void buscar() {
		
		catalogo.agregarItem(it);
		catalogo.agregarItem(it2);
		
		when(cb.cumple(it)).thenReturn(true);
		
		assertTrue(catalogo.buscar(cb).contains(it));
		assertEquals(catalogo.buscar(cb), List.of(it));
		assertFalse(catalogo.buscar(cb).contains(it2));
		
		when(cb2.cumple(it2)).thenReturn(true); 
		
		assertTrue(catalogo.buscar(cb2).contains(it2));
		assertEquals(catalogo.buscar(cb2), List.of(it2));
		assertFalse(catalogo.buscar(cb2).contains(it));	
	}
	
	@Test
	void buscarConOR() {

		OR or = new OR();
		
		catalogo.agregarItem(it);
		catalogo.agregarItem(it2);
		
		when(cb.cumple(it)).thenReturn(true);
		when(cb2.cumple(it)).thenReturn(false);
		when(cb3.cumple(it)).thenReturn(false);
		when(cb4.cumple(it)).thenReturn(false);
		
		when(cb.cumple(it2)).thenReturn(false);
		when(cb2.cumple(it2)).thenReturn(false);
		when(cb3.cumple(it2)).thenReturn(false);
		when(cb4.cumple(it2)).thenReturn(false);
		
		or.agregarCriterio(cb);
		or.agregarCriterio(cb2);
		or.agregarCriterio(cb3);
		or.agregarCriterio(cb4);
		
		assertEquals(catalogo.buscar(or), List.of(it)); 
		
		when(cb.cumple(it2)).thenReturn(false);
		when(cb2.cumple(it2)).thenReturn(false);
		when(cb3.cumple(it2)).thenReturn(true);
		when(cb4.cumple(it2)).thenReturn(false);
		
		assertEquals(catalogo.buscar(or), List.of(it,it2)); 
	}
	
	@Test
	void obtenerVentas() {

	    Pedido pedido = mock(Pedido.class);
	    EstadoPedido estado = mock(EstadoPedido.class);

	    Venta venta = mock(Venta.class);

	    when(pedido.getEstado()).thenReturn(estado);
	    when(estado.getEstadoString()).thenReturn("Entregado");
	    when(pedido.reporteDeVentas()).thenReturn(new ArrayList<>(List.of(venta)));

	    catalogo.agregarPedido(pedido);

	    ArrayList<Venta> resultado = catalogo.obtenerVentas();

	    assertEquals(1, resultado.size());
	    assertTrue(resultado.contains(venta));
	}

}
