package reporteTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import itemCatalogo.Catalogo;
import reporte.*;

public class ReporteMasVendidosTest {

    private Catalogo catalogo;
    private ArrayList<Venta> ventas;

    private Venta m1, m2, m3;
    private Venta t1, t2, t3, t4;
    private Venta p1, p2;
    
    private ReporteMasVendidos reporte;

    @BeforeEach
    void setUp() {

        catalogo = mock(Catalogo.class);

        ventas = new ArrayList<>();

        m1 = mock(Venta.class);
        when(m1.getNombre()).thenReturn("Mouse");
        when(m1.getPrecio()).thenReturn(100.0);
        m2 = mock(Venta.class);
        when(m2.getNombre()).thenReturn("Mouse");
        when(m2.getPrecio()).thenReturn(120.0);
        m3 = mock(Venta.class);
        when(m3.getNombre()).thenReturn("Mouse");
        when(m3.getPrecio()).thenReturn(110.0);

        t1 = mock(Venta.class);
        when(t1.getNombre()).thenReturn("Teclado");
        when(t1.getPrecio()).thenReturn(200.0);
        t2 = mock(Venta.class);
        when(t2.getNombre()).thenReturn("Teclado");
        when(t2.getPrecio()).thenReturn(220.0);
        t3 = mock(Venta.class);
        when(t3.getNombre()).thenReturn("Teclado");
        when(t3.getPrecio()).thenReturn(210.0);
        t4 = mock(Venta.class);
        when(t4.getNombre()).thenReturn("Teclado");
        when(t4.getPrecio()).thenReturn(230.0);

        p1 = mock(Venta.class);
        when(p1.getNombre()).thenReturn("Monitor");
        when(p1.getPrecio()).thenReturn(500.0);
        p2 = mock(Venta.class);
        when(p2.getNombre()).thenReturn("Monitor");
        when(p2.getPrecio()).thenReturn(600.0);

        reporte = new ReporteMasVendidos(catalogo);
        
        ventas.add(m1);
        ventas.add(m2);
        ventas.add(m3);

        ventas.add(t1);
        ventas.add(t2);
        ventas.add(t3);
        ventas.add(t4);

        ventas.add(p1);
        ventas.add(p2);
        
        when(catalogo.obtenerVentas()).thenReturn(ventas);
     
    }

    @Test
    void testCantidadYMayor() {
    	
    	ArrayList<ItemReporte> resultado = reporte.generar();
    	
        assertEquals(3, resultado.size());
        
        ItemReporte item = resultado.get(0);
        
        assertEquals(4, item.getCantidadVendida());
        
        assertTrue(item.getNombre().equals("Teclado"));
        
    }

    @Test
    void testCalculaPrecioPromedio() {

        ArrayList<ItemReporte> resultado = reporte.generar();

        ItemReporte item = resultado.get(1);
        
        assertTrue(item.getNombre().equals("Mouse"));
        
        assertEquals(item.getPrecioPromedio(), 110.0);

    }



    @Test
    void testOrdenaPorCantidadVendida() {
    	
        ArrayList<ItemReporte> resultado = reporte.generar();
        
        assertEquals(resultado.get(0).getNombre(), "Teclado");

        assertEquals(resultado.get(1).getNombre(),"Mouse");
        
        assertEquals(resultado.get(2).getNombre(),"Monitor");
    }

}