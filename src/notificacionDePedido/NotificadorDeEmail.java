package notificacionDePedido;

import pedido.*;

public class NotificadorDeEmail implements ObservadorPedido {
	
	private IMailSender mailsender;

	public NotificadorDeEmail(IMailSender mailsender) {
	    this.mailsender = mailsender;
	}

	@Override
	public void actualizar(Pedido pedido,EstadoPedido estado) {
		
		String emailDestinatario = pedido.getCliente().getEmail();
		String nombre = pedido.getCliente().getNombre();
		
		if (estado instanceof Confirmado) {
			mailsender.enviarMail(emailDestinatario, "¡PEDIDO CONFIRMADO!", 
									"Estimado " + nombre + ": El Pedido fue confirmado y pronto empezara su recorrido");
		}
		
		else if (estado instanceof Enviado) {
			mailsender.enviarMail(emailDestinatario, "PEDIDO ENVIADO",
								    "Estimado " + nombre + ": ¡El pedido esta en camino!");
		}
		
		else if (estado instanceof Entregado) {
			mailsender.enviarMail(emailDestinatario, "¡PEDIDO ENTREGADO!", 
									"Estimado " + nombre + ": Pedido entregado, que lo disfrutes ");
		}
	}
}
