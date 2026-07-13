package notificacionDePedido;

import pedido.*;

public interface ObservadorPedido {
	
	public void actualizar(Pedido pedido,EstadoPedido estado);

}
