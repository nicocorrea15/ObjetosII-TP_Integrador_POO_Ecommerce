package ItemCatalogoTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

import ItemCatalogo.*;

class ProductoTest {
	
	private Producto p1;
	
	@BeforeEach
	void setUp() {
		
		p1 = new Producto("SM11", "11", "Samsung", "Celular", 200.0, 0.10) ;
	}

	@Test
	void precioBase() {
		
		assertTrue(p1.getPrecioBase() == 200.0);
		
	}
	
	@Test 
	void precioFinal() {
		
		assertTrue(p1.getPrecioFinal() == 180);
		
	}

	@Test
	void nombre() {
		
		assertEquals(p1.getNombre(), "11");
		
	}
	
	@Test
	void descripcion() {
		
		assertEquals(p1.getDescripcion(), "Nombre: 11, Categoria: Celular, Marca: Samsung");
		
	}
	
	@Test 
	void id() {
		assertEquals(p1.getID(), "SM11");
	}
}
