package Envio;

import Pedido.*;

public interface Sucursal {
	
	public boolean tieneStock(Pedido pedido);
	public int tardanzaEntrega();

}
