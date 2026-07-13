package reporteTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import reporte.ItemReporte;

class ItemReporteTest {
	
	private ItemReporte itemReporte;

	@BeforeEach
	void setUp() {
		
		itemReporte = new ItemReporte("TV", 50, 500.0);
	}

	@Test
	void nombre() {
		assertEquals(itemReporte.getNombre(),"TV");
	}
	
	@Test
	void cantVendida() {
		assertEquals(itemReporte.getCantidadVendida(),50);
	}
	
	@Test
	void precio() {
		assertEquals(itemReporte.getPrecioPromedio(), 500.0);
	}

}
