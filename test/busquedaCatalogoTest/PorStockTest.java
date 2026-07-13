package busquedaCatalogoTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import busquedaCatalogo.*;
import itemCatalogo.ItemCatalogo;

class PorStockTest {
	
	private CriterioBusqueda porStock;
	private ItemCatalogo item;

	@BeforeEach
	void setUp() {
		
		item = mock(ItemCatalogo.class);
		when(item.getStock()).thenReturn(5);
		porStock = new PorStock();
	}

	@Test
	void cumple() {
		
		assertTrue(porStock.cumple(item));
	}
	
	@Test
	void noCumple() {
		
		when(item.getStock()).thenReturn(0);
		assertFalse(porStock.cumple(item));
	}
}
