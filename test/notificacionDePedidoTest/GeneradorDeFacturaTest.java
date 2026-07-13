package notificacionDePedidoTest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import notificacionDePedido.*;
import pedido.*;

class GeneradorDeFacturaTest {

    private GeneradorDeFactura generador;
    private Comprobante comprobante;

    private Pedido pedido;

    private EstadoPedido entregado;
    private EstadoPedido enviado;

    @BeforeEach
    void setUp() {

        comprobante = mock(Comprobante.class);

        pedido = mock(Pedido.class);

        entregado = mock(Entregado.class);
        enviado = mock(Enviado.class);

        generador = new GeneradorDeFactura(comprobante);
    }

    @Test
    void generarFacturaCuandoEstaEntregado() {

        generador.actualizar(pedido, entregado);

        verify(comprobante).crearComprobanteFiscal();
    }

    @Test
    void noGenerarFacturaSiNoEstaEntregado() {

        generador.actualizar(pedido, enviado);

        verifyNoInteractions(comprobante);
    }
}