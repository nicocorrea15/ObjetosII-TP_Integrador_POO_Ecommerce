package reporteTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import reporte.EstadisticaVenta;

class EstadisticaTest {
	
	private EstadisticaVenta estadistica;

	@BeforeEach
	void setUp() {
		
		estadistica = new EstadisticaVenta();
	}

	@Test
	void tests() {
		
		estadistica.agregarVenta(100.0);		
		assertEquals(estadistica.getCantidad(), 1);
		
		estadistica.agregarVenta(50.0);
		assertEquals(estadistica.getCantidad(), 2);
		
		assertEquals(estadistica.getPrecioPromedio(),75.0);
	}

}
