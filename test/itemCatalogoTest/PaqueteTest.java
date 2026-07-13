package itemCatalogoTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;

import itemCatalogo.*;

class PaqueteTest {
	
	private Paquete p1; 
	private ItemCatalogo p2; 
	private ItemCatalogo p3;
	private Paquete p4;
	private ItemCatalogo p5; 
	private ItemCatalogo p6;
	
	@BeforeEach
	void setUp() {
	 
	 p1 = new Paquete("Kit PC", 0.15,"PC");
	 p2 = mock(Producto.class); 
	 p3 = mock(Producto.class);
	 p4 = new Paquete("Kit mouse y teclado", 0.10,"Perifericos");
	 p5 = mock(Producto.class);
	 p6 = mock(Producto.class);
	 
	}
	
	@Test
	void categoria() {
		assertEquals(p4.getCategoria(),"Perifericos");
		assertEquals(p1.getCategoria(),"PC");
	}

	@Test
	void agregarItemYverificarCantItems() {
		
		p1.addProducto(p2);
		p1.addProducto(p3);
				
		p1.addProducto(p4);
		
		assertEquals(p1.cantItems(), 3);		
	}
	
	@Test
	void precioBase() {
		
		p1.addProducto(p2);
		p1.addProducto(p3);
		
		when(p2.getPrecioFinal()).thenReturn(200.0);
		when(p3.getPrecioFinal()).thenReturn(250.0);
		
		assertEquals(p1.getPrecioBase(), 450);	
	}
	
	@Test
	void precioFinal() {
		
		p1.addProducto(p2);
		p1.addProducto(p3);
		
		when(p2.getPrecioFinal()).thenReturn(200.0);
		when(p3.getPrecioFinal()).thenReturn(250.0);
		
		assertEquals(p1.getPrecioFinal(), 382,5);
	}
	
	@Test 
	void nombre() {
		assertEquals(p1.getNombre(), "Kit PC");
		assertEquals(p4.getNombre(), "Kit mouse y teclado");
	}
	
	@Test
	void descripcion() {
		assertEquals(p1.getDescripcion(), "Nombre: Kit PC");
		assertEquals(p4.getDescripcion(), "Nombre: Kit mouse y teclado");
	}
	
	@Test
	void precioBaseConPaquete() {
		
		p1.addProducto(p2);
		p1.addProducto(p3);
		
		p4.addProducto(p5);
		p4.addProducto(p6);
		
		p1.addProducto(p4);
		p1.addProducto(p6);
		
		when(p2.getPrecioFinal()).thenReturn(200.0);
		when(p3.getPrecioFinal()).thenReturn(250.0);
		
		when(p5.getPrecioFinal()).thenReturn(300.0);
		when(p6.getPrecioFinal()).thenReturn(100.0);
		
		assertEquals(p1.getPrecioBase(), 910);	
	}
	
	@Test
	void precioFinalConPaquete() {
		
		p1.addProducto(p2);
		p1.addProducto(p3);
		
		p4.addProducto(p5);
		p4.addProducto(p6);
		
		p1.addProducto(p4);
		p1.addProducto(p6);
		
		when(p2.getPrecioFinal()).thenReturn(200.0);
		when(p3.getPrecioFinal()).thenReturn(250.0);
		
		when(p5.getPrecioFinal()).thenReturn(300.0);
		when(p6.getPrecioFinal()).thenReturn(100.0);
		
		assertEquals(p1.getPrecioFinal(), 773.5);	
	}
	
	@Test
	void eliminarProductoDeLaLista() {
		
		p1.addProducto(p2);
		p1.addProducto(p3);
		
		assertTrue(p1.getCatalogo().contains(p2));
		
		p1.deleteProducto(p2);
		
		assertFalse(p1.getCatalogo().contains(p2));
	}
	
	@Test
	void verificarStock() {
		
		p1.addProducto(p3);
				
		when(p3.getStock()).thenReturn(20);
		
		assertEquals(p3.getStock(),20);
		
		p1.disminuirStock(1);
		
		verify(p3).disminuirStock(1);
		
		p1.aumentarStock(5);

		verify(p3).aumentarStock(5);
	}
	
	@Test
	void stock() {
		
		p1.addProducto(p2);
		when(p2.getStock()).thenReturn(20);
		p1.addProducto(p3);
		when(p3.getStock()).thenReturn(50);
		p1.addProducto(p6);
		when(p6.getStock()).thenReturn(100);
		
		assertEquals(p1.getStock(),170);
		
	}
	
	@Test
	void peso() {
		
		p1.addProducto(p2);
		p1.addProducto(p3);
		p1.addProducto(p5);
		
		when(p2.getPeso()).thenReturn(200);
		when(p3.getPeso()).thenReturn(300);
		when(p5.getPeso()).thenReturn(500);
		
		assertEquals(p1.getPeso(), 1000);
		
	}
}
