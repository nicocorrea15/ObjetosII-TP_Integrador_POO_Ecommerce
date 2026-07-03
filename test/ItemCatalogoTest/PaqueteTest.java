package ItemCatalogoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;

import ItemCatalogo.*;

class PaqueteTest {
	
	private Paquete p1; 
	private ItemCatalogo p2; 
	private ItemCatalogo p3;
	private Paquete p4;
	private ItemCatalogo p5; 
	private ItemCatalogo p6;
	private ArrayList<ItemCatalogo> catalogo;
	private ArrayList<ItemCatalogo> catalogo2;
	
	@BeforeEach
	void setUp() {
     
	 catalogo  = new ArrayList<>();
	 catalogo2 = new ArrayList<>();
	 
	 p1 = new Paquete("Kit PC", catalogo, 0.15);
	 p2 = mock(Producto.class); 
	 p3 = mock(Producto.class);
	 p4 = new Paquete("Kit mouse y teclado", catalogo2, 0.10);
	 p5 = mock(Producto.class);
	 p6 = mock(Producto.class);
	 
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
}
