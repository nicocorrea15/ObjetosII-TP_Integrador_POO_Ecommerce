package busquedaCatalogoTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import busquedaCatalogo.*;
import itemCatalogo.*;

class PorNombreTest {
	
	private CriterioBusqueda porNombre;
	private ItemCatalogo item;
	
	@BeforeEach
	void setUp() {
		
		item = mock(ItemCatalogo.class);
		when(item.getNombre()).thenReturn("TECLADO");
		porNombre = new PorNombre("COMPUTADORA");	
	}

	@Test
	void noCumpleCondicion() {
		
		assertFalse(porNombre.cumple(item));
	}
	
	@Test
	void cumpleCondicion() {

		when(item.getNombre()).thenReturn("COMPUTADORA");
		assertTrue(porNombre.cumple(item));
	}
}
