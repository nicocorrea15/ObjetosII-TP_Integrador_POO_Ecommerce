package busquedaCatalogoTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

import busquedaCatalogo.*;
import itemCatalogo.ItemCatalogo;

class BusquedaCompuestaTest {
	
	private AND compuestoAND;
	private OR compuestoOR;
	private NOT compuestoNOT;
	
	private CriterioBusqueda bi1; 
	private CriterioBusqueda bi2;
	private CriterioBusqueda bi3;
	private CriterioBusqueda bi4;
	private ItemCatalogo item;
	
	@BeforeEach
	void setUp() {
		
		compuestoAND = new AND();
		compuestoOR = new OR();
		
		item = mock(ItemCatalogo.class);
		bi1 = mock(CriterioBusqueda.class);
		bi2 = mock(CriterioBusqueda.class);
		bi3 = mock(CriterioBusqueda.class);
		bi4 = mock(CriterioBusqueda.class);
		
		compuestoNOT = new NOT(bi4);
		
		compuestoAND.agregarCriterio(bi1);
		compuestoAND.agregarCriterio(bi2);
		compuestoAND.agregarCriterio(bi3);
	}

	@Test
	void cumpleCompuestoAND() {
		
		when(bi1.cumple(item)).thenReturn(true);
		when(bi2.cumple(item)).thenReturn(true);
		when(bi3.cumple(item)).thenReturn(true);
		when(bi4.cumple(item)).thenReturn(false);
		
		compuestoAND.agregarCriterio(compuestoOR);
		compuestoAND.agregarCriterio(compuestoNOT);
		compuestoOR.agregarCriterio(bi1);	
		
		assertTrue(compuestoAND.cumple(item));
	}
	
	@Test
	void noCumpleCompuestoAND() {
		
		when(bi1.cumple(item)).thenReturn(false);		
		when(bi2.cumple(item)).thenReturn(true);		
		when(bi3.cumple(item)).thenReturn(true);	
				
		assertFalse(compuestoAND.cumple(item));
	}
	
	@Test 
	void cumpleCompuestoOR() {
		
		compuestoOR.agregarCriterio(compuestoAND);
		compuestoOR.agregarCriterio(bi1);
		
		when(compuestoAND.cumple(item)).thenReturn(false);
		when(bi1.cumple(item)).thenReturn(true);
		
		assertTrue(compuestoOR.cumple(item));
	}
	
	@Test
	void noCumpleCompuestoOR() {
		
		compuestoOR.agregarCriterio(compuestoAND);
		compuestoOR.agregarCriterio(bi1);
		
		when(compuestoAND.cumple(item)).thenReturn(false);
		when(bi1.cumple(item)).thenReturn(false);
		
		assertFalse(compuestoOR.cumple(item));
	}
	
	@Test
	void cumpleCompuestoNOT() {
		
		when(bi4.cumple(item)).thenReturn(false);
		assertTrue(compuestoNOT.cumple(item));
	}
	
	@Test
	void noCumpleCompuestoNOT() {
		
		when(bi4.cumple(item)).thenReturn(true);
		assertFalse(compuestoNOT.cumple(item));
	}

}
