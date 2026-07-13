package reporteTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import reporte.Venta;

class VentaTest {
	
	private Venta venta; 

	@BeforeEach
	void setUp() {
		
		venta = new Venta("TV",20.0);
	}

	@Test
	void test() {
		
		assertEquals(venta.getNombre(),"TV");
		assertEquals(venta.getPrecio(),20.0);
	}

}
