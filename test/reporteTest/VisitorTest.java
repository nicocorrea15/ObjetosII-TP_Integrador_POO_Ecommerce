package reporteTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import reporte.*;
import itemCatalogo.*;

class VisitorTest {

    private ReporteMasVendidos reporte;
    private Catalogo catalogo;
    private ArrayList<Venta> ventas;
    private Venta venta1;

    @BeforeEach
    void setUp() {

        catalogo = mock(Catalogo.class);

        ventas = new ArrayList<>();

        venta1 = mock(Venta.class);

        when(venta1.getNombre()).thenReturn("Mouse");
        when(venta1.getPrecio()).thenReturn(5000.0);

        ventas.add(venta1);

        when(catalogo.obtenerVentas()).thenReturn(ventas);

        reporte = new ReporteMasVendidos(catalogo);
    }

    @Test
    void testGeneraReporteTexto(){

        VisitorTexto visitor = new VisitorTexto();

        reporte.aceptar(visitor);

        assertTrue(visitor.getResultado().contains("Mouse"));
    }

    @Test
    void testGeneraReporteHTML(){

        VisitorHTML visitor = new VisitorHTML();

        reporte.aceptar(visitor);

        assertTrue(visitor.getResultado().contains("<table"));
    }

    @Test
    void testGeneraReporteCSV(){

        VisitorCSV visitor = new VisitorCSV();

        reporte.aceptar(visitor);

        assertTrue(visitor.getResultado().contains("Nombre,Cantidad"));
    }
}