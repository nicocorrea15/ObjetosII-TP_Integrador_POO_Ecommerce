package notificacionDePedidoTest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metodoDePago.Cliente;
import notificacionDePedido.*;
import pedido.*;

class NotificadorDeEmailTest {

    private NotificadorDeEmail notificador;
    private IMailSender mailSender;

    private Pedido pedido;
    private Cliente cliente;

    @BeforeEach
    void setUp() { 	

        mailSender = mock(IMailSender.class);
        pedido = mock(Pedido.class);
        cliente = mock(Cliente.class);

        when(pedido.getCliente()).thenReturn(cliente);
        when(cliente.getNombre()).thenReturn("Jose");
        when(cliente.getEmail()).thenReturn("emailC");

        notificador = new NotificadorDeEmail(mailSender);
    }

    @Test
    void actualizarConfirmado() {

    	EstadoPedido confirmado = mock(Confirmado.class);
    	
        notificador.actualizar(pedido, confirmado);

        verify(mailSender).enviarMail(
                "emailC",
                "¡PEDIDO CONFIRMADO!",
                "Estimado Jose: El Pedido fue confirmado y pronto empezara su recorrido");
    }

    @Test
    void actualizarEnviado() {

    	EstadoPedido enviado = mock(Enviado.class);
    	
        notificador.actualizar(pedido, enviado);

        verify(mailSender).enviarMail(
                "emailC",
                "PEDIDO ENVIADO",
                "Estimado Jose: ¡El pedido esta en camino!");
    }

    @Test
    void actualizarEntregado() {
    	
    	EstadoPedido entregado = mock(Entregado.class);

        notificador.actualizar(pedido, entregado);

        verify(mailSender).enviarMail(
                "emailC",
                "¡PEDIDO ENTREGADO!",
                "Estimado Jose: Pedido entregado, que lo disfrutes ");
    }
    
    @Test
    void noEnviarMailSiEstaEnBorrador() {

        EstadoPedido borrador = mock(Borrador.class);

        notificador.actualizar(pedido, borrador);

        verifyNoInteractions(mailSender);
    }
}