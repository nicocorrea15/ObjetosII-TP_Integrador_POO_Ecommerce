package metodoDeEnvio;

import pedido.Pedido;

public interface MetodoEnvio {
	
	public double costoEnvio(Pedido pedido);
	public int diasDeEntrega(Pedido pedido); 
}
