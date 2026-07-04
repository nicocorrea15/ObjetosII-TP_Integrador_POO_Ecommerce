package Envio;

import Pedido.*;

public class RetiroEnSucursal extends Envio {
	
	private Sucursal sucursal;

	public RetiroEnSucursal(Pedido pedido,Sucursal sucursal1) {
		super(pedido);
		sucursal = sucursal1;
	}

	@Override
	public float costoEnvio() {
		return 0;
	}

	@Override
	public int diasDeEntrega() {
		
		if (sucursal.tieneStock(pedido)) {
			return 0;
		}
		
		return sucursal.tardanzaEntrega();
	}

}
