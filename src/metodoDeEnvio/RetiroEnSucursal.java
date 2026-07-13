package metodoDeEnvio;

import pedido.*;

public class RetiroEnSucursal implements MetodoEnvio {
	
	private Sucursal sucursal;

	public RetiroEnSucursal(Sucursal sucursal1) {
		sucursal = sucursal1;
	}

	@Override
	public double costoEnvio(Pedido pedido) {
		return 0;
	}

	@Override
	public int diasDeEntrega(Pedido pedido) {
		
		if (sucursal.tieneStock(pedido)) {
			return 0;
		}
		
		return sucursal.tardanzaEntrega();
	}

}
