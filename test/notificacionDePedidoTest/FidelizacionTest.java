package notificacionDePedidoTest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metodoDePago.Cliente;
import notificacionDePedido.*;
import pedido.*;

class FidelizacionTest {

    private Fidelizacion fidelizacion;
    private IMailSender mailSender;

    private Pedido pedido;
    private Cliente cliente;

    private EstadoPedido cancelado;
    private EstadoPedido confirmado;

    @BeforeEach
    void setUp() {

        cancelado = mock(Cancelado.class);
        confirmado = mock(Confirmado.class);

        mailSender = mock(IMailSender.class);
        pedido = mock(Pedido.class);
        cliente = mock(Cliente.class);

        when(pedido.getCliente()).thenReturn(cliente);
        when(cliente.getNombre()).thenReturn("Jose");
        when(cliente.getEmail()).thenReturn("emailC");

        fidelizacion = new Fidelizacion(mailSender);
    }

    @Test
    void actualizarCancelado() {

        fidelizacion.actualizar(pedido, cancelado);

        verify(mailSender).enviarMail(
                "emailC",
                "¡PEDIDO CANCELADO!",
                "Estimado Jose: El pedido fue cancelado, a continuacion se le otorgara un cupon de descuento del 5% en su proxima compra");
    }

    @Test
    void noEnviarMailSiNoEstaCancelado() {

        fidelizacion.actualizar(pedido, confirmado);

        verifyNoInteractions(mailSender);
    }
}