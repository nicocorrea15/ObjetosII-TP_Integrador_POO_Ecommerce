package ItemCatalogoTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;

import ItemCatalogo.*;

class ProductoTest {
	
	private Producto p1;
	private ArrayList<Atributo> atributos;
	private Atributo a1; 
	private Atributo a2;
	
	@BeforeEach
	void setUp() {
		
		atributos = new ArrayList<>();
		
		a1 = mock(Atributo.class);
		a2 = mock(Atributo.class);
		
		p1 = new Producto("SM11", "11", "Samsung", "Celular", 200.0, 0.10, atributos, 20,300) ;
	}

	@Test
	void precioBase() {
		
		assertTrue(p1.getPrecioBase() == 200.0);
		
	}
	
	@Test
	void verificarAtributo() {
		
		when(a1.nombre()).thenReturn("Altura"); 
		when(a1.valor()).thenReturn(20);
		
		when(a2.nombre()).thenReturn("Ancho"); 
		when(a2.valor()).thenReturn(1);
		
		p1.agregarAtributo(a1);
		p1.agregarAtributo(a2);
		
		assertTrue(p1.validar());
	}
	
	@Test
	void atributos() {
		
		assertEquals(p1.getAtributo(), atributos);
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
	
	@Test 
	void stock() {
		
		assertEquals(p1.getStock(), 20);
		
		p1.disminuirStock(1); 
		
		assertEquals(p1.getStock(), 19);
		
		p1.aumentarStock(3); 
		
		assertEquals(p1.getStock(), 22);
	}
	
	@Test
	void peso() {
		
		assertEquals(p1.getPeso(),300);		
	}
}
