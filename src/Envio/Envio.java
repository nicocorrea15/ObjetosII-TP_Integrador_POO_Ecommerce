package Envio;

import Pedido.*;

public abstract class Envio {
	
	protected Pedido pedido;
	
	public Envio(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public abstract float costoEnvio();
	public abstract int diasDeEntrega(); 
}
