package busquedaCatalogoTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import busquedaCatalogo.*;
import itemCatalogo.*;

class PorCategoriaTest {
	
	private CriterioBusqueda porCategoria;
	private ItemCatalogo item;
	
	@BeforeEach
	void setUp() {
		
		item = mock(ItemCatalogo.class);
		when(item.getCategoria()).thenReturn("KIT PC");
		porCategoria = new PorCategoria("TECNOLOGIA");	
	}

	@Test
	void noCumpleCondicion() {
		
		assertFalse(porCategoria.cumple(item));
	}
	
	@Test
	void cumpleCondicion() {

		when(item.getCategoria()).thenReturn("TECNOLOGIA");
		assertTrue(porCategoria.cumple(item));
	}
}