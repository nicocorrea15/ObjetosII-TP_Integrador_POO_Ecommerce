package notificacionDePedido;

import pedido.*;

public class Fidelizacion implements ObservadorPedido {
	
	private IMailSender mailSender;

	public Fidelizacion(IMailSender mailSender) {
	    this.mailSender = mailSender;
	}

	@Override
	public void actualizar(Pedido pedido, EstadoPedido estado) {
		
		if(estado instanceof Cancelado) {
			
			String emailDestinatario = pedido.getCliente().getEmail();
			String nombre = pedido.getCliente().getNombre();
			
			mailSender.enviarMail(emailDestinatario, "¡PEDIDO CANCELADO!", 	
						"Estimado " + nombre + ": El pedido fue cancelado, a continuacion se le otorgara un cupon de descuento del 5% en su proxima compra");
		}
	}
}
