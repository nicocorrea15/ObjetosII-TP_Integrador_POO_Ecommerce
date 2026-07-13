package metodoDeEnvio;

import pedido.*;

public interface Sucursal {
	
	public boolean tieneStock(Pedido pedido);
	public int tardanzaEntrega();

}
