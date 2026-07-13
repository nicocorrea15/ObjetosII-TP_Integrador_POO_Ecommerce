package busquedaCatalogoTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import busquedaCatalogo.*;
import itemCatalogo.ItemCatalogo;

class PorPrecioTest {
	
	private CriterioBusqueda porPrecio;
	private ItemCatalogo item;

	@BeforeEach
	void setUp() {
		
		item = mock(ItemCatalogo.class);
		when(item.getPrecioBase()).thenReturn(500.0);
		porPrecio = new PorPrecio(400.0);	
	}

	@Test
	void noCumple() {
		
		assertFalse(porPrecio.cumple(item));
	}
	
	@Test
	void cumple() {
		
		when(item.getPrecioBase()).thenReturn(300.0);
		assertTrue(porPrecio.cumple(item));
	}
}
